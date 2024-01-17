package com.google.common.eventbus;

@ElementTypesAreNonnullByDefault
public interface SubscriberExceptionHandler {
  void handleException(Throwable paramThrowable, SubscriberExceptionContext paramSubscriberExceptionContext);
}
