package org.apache.commons.codec;

public interface StringDecoder extends Decoder {
  String decode(String paramString) throws DecoderException;
}
