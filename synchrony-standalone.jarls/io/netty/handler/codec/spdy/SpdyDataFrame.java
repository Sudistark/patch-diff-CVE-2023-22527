package io.netty.handler.codec.spdy;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;

public interface SpdyDataFrame extends ByteBufHolder, SpdyStreamFrame {
  SpdyDataFrame setStreamId(int paramInt);
  
  SpdyDataFrame setLast(boolean paramBoolean);
  
  ByteBuf content();
  
  SpdyDataFrame copy();
  
  SpdyDataFrame duplicate();
  
  SpdyDataFrame retainedDuplicate();
  
  SpdyDataFrame replace(ByteBuf paramByteBuf);
  
  SpdyDataFrame retain();
  
  SpdyDataFrame retain(int paramInt);
  
  SpdyDataFrame touch();
  
  SpdyDataFrame touch(Object paramObject);
}
