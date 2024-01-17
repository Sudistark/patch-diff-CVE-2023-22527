package io.netty.handler.codec;

public interface DecoderResultProvider {
  DecoderResult decoderResult();
  
  void setDecoderResult(DecoderResult paramDecoderResult);
}
