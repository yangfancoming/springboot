package com.goat.eventbus;

import java.util.concurrent.Executor;

/**
 * Created by 64274 on 2019/7/25.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/7/25---22:35
 */
public class EventBus {

    //  identifier表示：唯一标识，默认为default ，同一个应用中，可以根据identifier来区分不同的事件总线，只不过默认为default而已。
    private final String identifier;
    //多线程处理器，默认MoreExecutors.directExecutor()
    private final Executor executor;
    //异常处理器
    private final SubscriberExceptionHandler exceptionHandler;

    //消息分发器，默认为Dispatcher.perThreadDispatchQueue()，单线程消息分发队列
    private final Dispatcher dispatcher;

    //订阅注册表
    private final SubscriberRegistry subscribers = new SubscriberRegistry(this);


    /** Creates a new EventBus named "default". */
    public EventBus() {
        this("default");
    }

    public EventBus(String identifier) {
        this(identifier,null,null, null);
    }

    EventBus( String identifier, Executor executor, Dispatcher dispatcher, SubscriberExceptionHandler exceptionHandler) {
        this.identifier = identifier;
        this.executor = executor;
        this.dispatcher = dispatcher;
        this.exceptionHandler = exceptionHandler;
    }

    final Executor executor() {
        return executor;
    }





    public void register(Object object) {
        subscribers.register(object);
    }


}
