package io.netty.channel.socket;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelConfig;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;

public interface DuplexChannelConfig extends ChannelConfig {
  boolean isAllowHalfClosure();
  
  DuplexChannelConfig setAllowHalfClosure(boolean paramBoolean);
  
  @Deprecated
  DuplexChannelConfig setMaxMessagesPerRead(int paramInt);
  
  DuplexChannelConfig setWriteSpinCount(int paramInt);
  
  DuplexChannelConfig setAllocator(ByteBufAllocator paramByteBufAllocator);
  
  DuplexChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator paramRecvByteBufAllocator);
  
  DuplexChannelConfig setAutoRead(boolean paramBoolean);
  
  DuplexChannelConfig setAutoClose(boolean paramBoolean);
  
  DuplexChannelConfig setMessageSizeEstimator(MessageSizeEstimator paramMessageSizeEstimator);
  
  DuplexChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark paramWriteBufferWaterMark);
}
