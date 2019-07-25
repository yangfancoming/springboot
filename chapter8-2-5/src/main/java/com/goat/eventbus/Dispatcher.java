

package com.goat.eventbus;


import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;


/**
 * Handler for dispatching events to subscribers, providing different event ordering guarantees that
 * make sense for different situations.
 *
 * <p><b>Note:</b> The dispatcher is orthogonal to the subscriber's {@code Executor}. The dispatcher
 * controls the order in which events are dispatched, while the executor controls how (i.e. on which
 * thread) the subscriber is actually called when an event is dispatched to it.
 *
 * @author Colin Decker
 */
abstract class Dispatcher {


    static Dispatcher perThreadDispatchQueue() {
        return new PerThreadQueuedDispatcher();
    }


    static Dispatcher legacyAsync() {
        return new LegacyAsyncDispatcher();
    }

    static Dispatcher immediate() {
        return ImmediateDispatcher.INSTANCE;
    }

    /** Dispatches the given {@code event} to the given {@code subscribers}. */
    // 分发器，用于将event分发给subscriber。它内部实现了三种不同类型的分发器，用于不同的情况下事件的顺序性。它的核心方法是：
    abstract void dispatch(Object event, Iterator<Subscriber> subscribers);

    /** Implementation of a {@link #perThreadDispatchQueue()} dispatcher. */
    private static final class PerThreadQueuedDispatcher extends Dispatcher {

        // This dispatcher matches the original dispatch behavior of EventBus.

        /** Per-thread queue of events to dispatch. */
        private final ThreadLocal<Queue<Event>> queue = ThreadLocal.withInitial(()-> new ArrayDeque<>());

        /** Per-thread dispatch state, used to avoid reentrant event dispatching. */
        private final ThreadLocal<Boolean> dispatching = ThreadLocal.withInitial(()->false);

        // EventBus默认使用的分发器。它的实现是通过ThreadLocal来实现一个事件队列，每个线程包含一个这样的内部队列。
        // 嵌套两层循环，第一层事件不为空，第二层该事件下的订阅者不为空，则分发事件下去。
        @Override
        void dispatch(Object event, Iterator<Subscriber> subscribers) {
            Queue<Event> queueForThread = queue.get();
            queueForThread.offer(new Event(event, subscribers));

            if (!dispatching.get()) {
                dispatching.set(true);
                try {
                    Event nextEvent;
                    while ((nextEvent = queueForThread.poll()) != null) {
                        while (nextEvent.subscribers.hasNext()) {
                            nextEvent.subscribers.next().dispatchEvent(nextEvent.event);
                        }
                    }
                } finally {
                    dispatching.remove();
                    queue.remove();
                }
            }
        }

        private static final class Event {
            private final Object event;
            private final Iterator<Subscriber> subscribers;

            private Event(Object event, Iterator<Subscriber> subscribers) {
                this.event = event;
                this.subscribers = subscribers;
            }
        }
    }

    /** Implementation of a {@link #legacyAsync()} dispatcher. */
    private static final class LegacyAsyncDispatcher extends Dispatcher {


        /** Global event queue. */
        private final ConcurrentLinkedQueue<EventWithSubscriber> queue = new ConcurrentLinkedQueue();


        // AsyncEventBus使用的分发器。它在内部通过一个ConcurrentLinkedQueue的全局队列来存储事件。他和PerThreadQueuedDispatcher的主要区别在于分发循环这块
        // 是一前一后两个循环。前面一个是遍历事件订阅处理器，并构建一个事件实体对象存入队列。后一个循环是遍历该事件实体对象队列，取出事件实体对象中的事件进行分发。
        @Override
        void dispatch(Object event, Iterator<Subscriber> subscribers) {
            while (subscribers.hasNext()) {
                queue.add(new EventWithSubscriber(event, subscribers.next()));
            }
            EventWithSubscriber e;
            while ((e = queue.poll()) != null) {
                e.subscriber.dispatchEvent(e.event);
            }
        }

        private static final class EventWithSubscriber {
            private final Object event;
            private final Subscriber subscriber;
            private EventWithSubscriber(Object event, Subscriber subscriber) {
                this.event = event;
                this.subscriber = subscriber;
            }
        }
    }

    /** Implementation of {@link #immediate()}. */
    private static final class ImmediateDispatcher extends Dispatcher {
        private static final ImmediateDispatcher INSTANCE = new ImmediateDispatcher();
        // 同步分发器。
        @Override
        void dispatch(Object event, Iterator<Subscriber> subscribers) {
            while (subscribers.hasNext()) {
                subscribers.next().dispatchEvent(event);
            }
        }
    }
}
