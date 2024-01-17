package io.netty.util.concurrent;

import java.util.concurrent.ScheduledFuture;

public interface ScheduledFuture<V> extends Future<V>, ScheduledFuture<V> {}
