package io.netty.util;

public interface ResourceLeakTracker<T> {
  void record();
  
  void record(Object paramObject);
  
  boolean close(T paramT);
}
