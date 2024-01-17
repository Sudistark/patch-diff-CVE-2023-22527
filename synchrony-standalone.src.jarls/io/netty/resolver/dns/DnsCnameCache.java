package io.netty.resolver.dns;

import io.netty.channel.EventLoop;

public interface DnsCnameCache {
  String get(String paramString);
  
  void cache(String paramString1, String paramString2, long paramLong, EventLoop paramEventLoop);
  
  void clear();
  
  boolean clear(String paramString);
}
