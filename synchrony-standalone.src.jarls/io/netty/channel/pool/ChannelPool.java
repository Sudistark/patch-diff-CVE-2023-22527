package io.netty.channel.pool;

import io.netty.channel.Channel;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.Promise;
import java.io.Closeable;

public interface ChannelPool extends Closeable {
  Future<Channel> acquire();
  
  Future<Channel> acquire(Promise<Channel> paramPromise);
  
  Future<Void> release(Channel paramChannel);
  
  Future<Void> release(Channel paramChannel, Promise<Void> paramPromise);
  
  void close();
}
