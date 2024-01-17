package io.netty.channel;

import io.netty.buffer.ByteBufAllocator;
import java.util.Map;

public interface ChannelConfig {
  Map<ChannelOption<?>, Object> getOptions();
  
  boolean setOptions(Map<ChannelOption<?>, ?> paramMap);
  
  <T> T getOption(ChannelOption<T> paramChannelOption);
  
  <T> boolean setOption(ChannelOption<T> paramChannelOption, T paramT);
  
  int getConnectTimeoutMillis();
  
  ChannelConfig setConnectTimeoutMillis(int paramInt);
  
  @Deprecated
  int getMaxMessagesPerRead();
  
  @Deprecated
  ChannelConfig setMaxMessagesPerRead(int paramInt);
  
  int getWriteSpinCount();
  
  ChannelConfig setWriteSpinCount(int paramInt);
  
  ByteBufAllocator getAllocator();
  
  ChannelConfig setAllocator(ByteBufAllocator paramByteBufAllocator);
  
  <T extends RecvByteBufAllocator> T getRecvByteBufAllocator();
  
  ChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator paramRecvByteBufAllocator);
  
  boolean isAutoRead();
  
  ChannelConfig setAutoRead(boolean paramBoolean);
  
  boolean isAutoClose();
  
  ChannelConfig setAutoClose(boolean paramBoolean);
  
  int getWriteBufferHighWaterMark();
  
  ChannelConfig setWriteBufferHighWaterMark(int paramInt);
  
  int getWriteBufferLowWaterMark();
  
  ChannelConfig setWriteBufferLowWaterMark(int paramInt);
  
  MessageSizeEstimator getMessageSizeEstimator();
  
  ChannelConfig setMessageSizeEstimator(MessageSizeEstimator paramMessageSizeEstimator);
  
  WriteBufferWaterMark getWriteBufferWaterMark();
  
  ChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark paramWriteBufferWaterMark);
}
