package io.netty.channel.socket.oio;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;
import io.netty.channel.socket.ServerSocketChannelConfig;

@Deprecated
public interface OioServerSocketChannelConfig extends ServerSocketChannelConfig {
  OioServerSocketChannelConfig setSoTimeout(int paramInt);
  
  int getSoTimeout();
  
  OioServerSocketChannelConfig setBacklog(int paramInt);
  
  OioServerSocketChannelConfig setReuseAddress(boolean paramBoolean);
  
  OioServerSocketChannelConfig setReceiveBufferSize(int paramInt);
  
  OioServerSocketChannelConfig setPerformancePreferences(int paramInt1, int paramInt2, int paramInt3);
  
  OioServerSocketChannelConfig setConnectTimeoutMillis(int paramInt);
  
  @Deprecated
  OioServerSocketChannelConfig setMaxMessagesPerRead(int paramInt);
  
  OioServerSocketChannelConfig setWriteSpinCount(int paramInt);
  
  OioServerSocketChannelConfig setAllocator(ByteBufAllocator paramByteBufAllocator);
  
  OioServerSocketChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator paramRecvByteBufAllocator);
  
  OioServerSocketChannelConfig setAutoRead(boolean paramBoolean);
  
  OioServerSocketChannelConfig setAutoClose(boolean paramBoolean);
  
  OioServerSocketChannelConfig setWriteBufferHighWaterMark(int paramInt);
  
  OioServerSocketChannelConfig setWriteBufferLowWaterMark(int paramInt);
  
  OioServerSocketChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark paramWriteBufferWaterMark);
  
  OioServerSocketChannelConfig setMessageSizeEstimator(MessageSizeEstimator paramMessageSizeEstimator);
}
