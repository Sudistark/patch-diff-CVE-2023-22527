package io.netty.handler.codec.http.multipart;

import io.netty.buffer.ByteBuf;
import java.io.IOException;

public interface Attribute extends HttpData {
  String getValue() throws IOException;
  
  void setValue(String paramString) throws IOException;
  
  Attribute copy();
  
  Attribute duplicate();
  
  Attribute retainedDuplicate();
  
  Attribute replace(ByteBuf paramByteBuf);
  
  Attribute retain();
  
  Attribute retain(int paramInt);
  
  Attribute touch();
  
  Attribute touch(Object paramObject);
}
