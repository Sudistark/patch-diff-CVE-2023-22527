package io.netty.util;

public interface ReferenceCounted {
  int refCnt();
  
  ReferenceCounted retain();
  
  ReferenceCounted retain(int paramInt);
  
  ReferenceCounted touch();
  
  ReferenceCounted touch(Object paramObject);
  
  boolean release();
  
  boolean release(int paramInt);
}
