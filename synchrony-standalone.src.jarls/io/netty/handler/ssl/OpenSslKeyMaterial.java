package io.netty.handler.ssl;

import io.netty.util.ReferenceCounted;
import java.security.cert.X509Certificate;

interface OpenSslKeyMaterial extends ReferenceCounted {
  X509Certificate[] certificateChain();
  
  long certificateChainAddress();
  
  long privateKeyAddress();
  
  OpenSslKeyMaterial retain();
  
  OpenSslKeyMaterial retain(int paramInt);
  
  OpenSslKeyMaterial touch();
  
  OpenSslKeyMaterial touch(Object paramObject);
  
  boolean release();
  
  boolean release(int paramInt);
}
