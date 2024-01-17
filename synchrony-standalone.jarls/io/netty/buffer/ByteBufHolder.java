package io.netty.buffer;

import io.netty.util.ReferenceCounted;

public interface ByteBufHolder extends ReferenceCounted {
  ByteBuf content();
  
  ByteBufHolder copy();
  
  ByteBufHolder duplicate();
  
  ByteBufHolder retainedDuplicate();
  
  ByteBufHolder replace(ByteBuf paramByteBuf);
  
  ByteBufHolder retain();
  
  ByteBufHolder retain(int paramInt);
  
  ByteBufHolder touch();
  
  ByteBufHolder touch(Object paramObject);
}
