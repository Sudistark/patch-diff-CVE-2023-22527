package io.netty.channel.socket;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;

public interface SocketChannelConfig extends DuplexChannelConfig {
  boolean isTcpNoDelay();
  
  SocketChannelConfig setTcpNoDelay(boolean paramBoolean);
  
  int getSoLinger();
  
  SocketChannelConfig setSoLinger(int paramInt);
  
  int getSendBufferSize();
  
  SocketChannelConfig setSendBufferSize(int paramInt);
  
  int getReceiveBufferSize();
  
  SocketChannelConfig setReceiveBufferSize(int paramInt);
  
  boolean isKeepAlive();
  
  SocketChannelConfig setKeepAlive(boolean paramBoolean);
  
  int getTrafficClass();
  
  SocketChannelConfig setTrafficClass(int paramInt);
  
  boolean isReuseAddress();
  
  SocketChannelConfig setReuseAddress(boolean paramBoolean);
  
  SocketChannelConfig setPerformancePreferences(int paramInt1, int paramInt2, int paramInt3);
  
  SocketChannelConfig setAllowHalfClosure(boolean paramBoolean);
  
  SocketChannelConfig setConnectTimeoutMillis(int paramInt);
  
  @Deprecated
  SocketChannelConfig setMaxMessagesPerRead(int paramInt);
  
  SocketChannelConfig setWriteSpinCount(int paramInt);
  
  SocketChannelConfig setAllocator(ByteBufAllocator paramByteBufAllocator);
  
  SocketChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator paramRecvByteBufAllocator);
  
  SocketChannelConfig setAutoRead(boolean paramBoolean);
  
  SocketChannelConfig setAutoClose(boolean paramBoolean);
  
  SocketChannelConfig setMessageSizeEstimator(MessageSizeEstimator paramMessageSizeEstimator);
  
  SocketChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark paramWriteBufferWaterMark);
}
