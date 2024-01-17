package io.netty.resolver;

import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.Promise;
import java.io.Closeable;
import java.net.SocketAddress;
import java.util.List;

public interface AddressResolver<T extends SocketAddress> extends Closeable {
  boolean isSupported(SocketAddress paramSocketAddress);
  
  boolean isResolved(SocketAddress paramSocketAddress);
  
  Future<T> resolve(SocketAddress paramSocketAddress);
  
  Future<T> resolve(SocketAddress paramSocketAddress, Promise<T> paramPromise);
  
  Future<List<T>> resolveAll(SocketAddress paramSocketAddress);
  
  Future<List<T>> resolveAll(SocketAddress paramSocketAddress, Promise<List<T>> paramPromise);
  
  void close();
}
