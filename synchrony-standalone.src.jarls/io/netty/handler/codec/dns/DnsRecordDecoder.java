package io.netty.handler.codec.dns;

import io.netty.buffer.ByteBuf;

public interface DnsRecordDecoder {
  public static final DnsRecordDecoder DEFAULT = new DefaultDnsRecordDecoder();
  
  DnsQuestion decodeQuestion(ByteBuf paramByteBuf) throws Exception;
  
  <T extends DnsRecord> T decodeRecord(ByteBuf paramByteBuf) throws Exception;
}
