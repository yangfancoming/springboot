

package com.goat.eventbus;

/**
 * Handler for exceptions thrown by event subscribers.
 * @since 16.0
 */
public interface SubscriberExceptionHandler {
  /** Handles exceptions thrown by subscribers. */
  void handleException(Throwable exception, SubscriberExceptionContext context);
}
