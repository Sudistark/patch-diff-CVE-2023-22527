package io.netty.handler.codec.dns;

import io.netty.buffer.ByteBuf;

public interface DnsRecordEncoder {
  public static final DnsRecordEncoder DEFAULT = new DefaultDnsRecordEncoder();
  
  void encodeQuestion(DnsQuestion paramDnsQuestion, ByteBuf paramByteBuf) throws Exception;
  
  void encodeRecord(DnsRecord paramDnsRecord, ByteBuf paramByteBuf) throws Exception;
}
