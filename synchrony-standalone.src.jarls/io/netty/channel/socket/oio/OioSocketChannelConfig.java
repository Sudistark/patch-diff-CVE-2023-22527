package io.netty.channel.socket.oio;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;
import io.netty.channel.socket.SocketChannelConfig;

@Deprecated
public interface OioSocketChannelConfig extends SocketChannelConfig {
  OioSocketChannelConfig setSoTimeout(int paramInt);
  
  int getSoTimeout();
  
  OioSocketChannelConfig setTcpNoDelay(boolean paramBoolean);
  
  OioSocketChannelConfig setSoLinger(int paramInt);
  
  OioSocketChannelConfig setSendBufferSize(int paramInt);
  
  OioSocketChannelConfig setReceiveBufferSize(int paramInt);
  
  OioSocketChannelConfig setKeepAlive(boolean paramBoolean);
  
  OioSocketChannelConfig setTrafficClass(int paramInt);
  
  OioSocketChannelConfig setReuseAddress(boolean paramBoolean);
  
  OioSocketChannelConfig setPerformancePreferences(int paramInt1, int paramInt2, int paramInt3);
  
  OioSocketChannelConfig setAllowHalfClosure(boolean paramBoolean);
  
  OioSocketChannelConfig setConnectTimeoutMillis(int paramInt);
  
  @Deprecated
  OioSocketChannelConfig setMaxMessagesPerRead(int paramInt);
  
  OioSocketChannelConfig setWriteSpinCount(int paramInt);
  
  OioSocketChannelConfig setAllocator(ByteBufAllocator paramByteBufAllocator);
  
  OioSocketChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator paramRecvByteBufAllocator);
  
  OioSocketChannelConfig setAutoRead(boolean paramBoolean);
  
  OioSocketChannelConfig setAutoClose(boolean paramBoolean);
  
  OioSocketChannelConfig setWriteBufferHighWaterMark(int paramInt);
  
  OioSocketChannelConfig setWriteBufferLowWaterMark(int paramInt);
  
  OioSocketChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark paramWriteBufferWaterMark);
  
  OioSocketChannelConfig setMessageSizeEstimator(MessageSizeEstimator paramMessageSizeEstimator);
}
