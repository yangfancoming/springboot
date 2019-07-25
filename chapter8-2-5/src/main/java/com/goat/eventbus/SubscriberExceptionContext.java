

package com.goat.eventbus;

import java.lang.reflect.Method;


/**
 * Context for an exception thrown by a subscriber.
 *
 * @since 16.0
 */
public class SubscriberExceptionContext {
  private final EventBus eventBus;
  private final Object event;
  private final Object subscriber;
  private final Method subscriberMethod;

  /**
   * @param eventBus The {@link EventBus} that handled the event and the subscriber. Useful for
   *     broadcasting a a new event based on the error.
   * @param event The event object that caused the subscriber to throw.
   * @param subscriber The source subscriber context.
   * @param subscriberMethod the subscribed method.
   */
  SubscriberExceptionContext(
      EventBus eventBus, Object event, Object subscriber, Method subscriberMethod) {
    this.eventBus = eventBus;
    this.event = event;
    this.subscriber = subscriber;
    this.subscriberMethod = subscriberMethod;
  }

  /**
   * @return The {@link EventBus} that handled the event and the subscriber. Useful for broadcasting
   *     a a new event based on the error.
   */
  public EventBus getEventBus() {
    return eventBus;
  }

  /** @return The event object that caused the subscriber to throw. */
  public Object getEvent() {
    return event;
  }

  /** @return The object context that the subscriber was called on. */
  public Object getSubscriber() {
    return subscriber;
  }

  /** @return The subscribed method that threw the exception. */
  public Method getSubscriberMethod() {
    return subscriberMethod;
  }
}
