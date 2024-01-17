package io.netty.channel.pool;

import io.netty.channel.Channel;

public interface ChannelPoolHandler {
  void channelReleased(Channel paramChannel) throws Exception;
  
  void channelAcquired(Channel paramChannel) throws Exception;
  
  void channelCreated(Channel paramChannel) throws Exception;
}
