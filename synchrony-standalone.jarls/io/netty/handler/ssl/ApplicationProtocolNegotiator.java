package io.netty.handler.ssl;

import java.util.List;

public interface ApplicationProtocolNegotiator {
  List<String> protocols();
}
