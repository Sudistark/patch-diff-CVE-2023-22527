package com.google.common.util.concurrent.internal;

public abstract class InternalFutureFailureAccess {
  protected abstract Throwable tryInternalFastPathGetFailure();
}
