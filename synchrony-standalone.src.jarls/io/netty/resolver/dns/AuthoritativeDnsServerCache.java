package io.netty.resolver.dns;

import io.netty.channel.EventLoop;
import java.net.InetSocketAddress;

public interface AuthoritativeDnsServerCache {
  DnsServerAddressStream get(String paramString);
  
  void cache(String paramString, InetSocketAddress paramInetSocketAddress, long paramLong, EventLoop paramEventLoop);
  
  void clear();
  
  boolean clear(String paramString);
}
