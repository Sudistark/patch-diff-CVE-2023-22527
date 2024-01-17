package io.netty.resolver;

import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.Promise;
import java.io.Closeable;
import java.util.List;

public interface NameResolver<T> extends Closeable {
  Future<T> resolve(String paramString);
  
  Future<T> resolve(String paramString, Promise<T> paramPromise);
  
  Future<List<T>> resolveAll(String paramString);
  
  Future<List<T>> resolveAll(String paramString, Promise<List<T>> paramPromise);
  
  void close();
}
