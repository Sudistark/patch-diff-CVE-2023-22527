package io.netty.channel.unix;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelConfig;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;

public interface DomainDatagramChannelConfig extends ChannelConfig {
  DomainDatagramChannelConfig setAllocator(ByteBufAllocator paramByteBufAllocator);
  
  DomainDatagramChannelConfig setAutoClose(boolean paramBoolean);
  
  DomainDatagramChannelConfig setAutoRead(boolean paramBoolean);
  
  DomainDatagramChannelConfig setConnectTimeoutMillis(int paramInt);
  
  @Deprecated
  DomainDatagramChannelConfig setMaxMessagesPerRead(int paramInt);
  
  DomainDatagramChannelConfig setMessageSizeEstimator(MessageSizeEstimator paramMessageSizeEstimator);
  
  DomainDatagramChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator paramRecvByteBufAllocator);
  
  DomainDatagramChannelConfig setSendBufferSize(int paramInt);
  
  int getSendBufferSize();
  
  DomainDatagramChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark paramWriteBufferWaterMark);
  
  DomainDatagramChannelConfig setWriteSpinCount(int paramInt);
}
