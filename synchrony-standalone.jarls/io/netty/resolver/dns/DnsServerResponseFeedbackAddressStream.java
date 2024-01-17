package io.netty.resolver.dns;

import java.net.InetSocketAddress;

public interface DnsServerResponseFeedbackAddressStream extends DnsServerAddressStream {
  void feedbackSuccess(InetSocketAddress paramInetSocketAddress, long paramLong);
  
  void feedbackFailure(InetSocketAddress paramInetSocketAddress, Throwable paramThrowable, long paramLong);
}
