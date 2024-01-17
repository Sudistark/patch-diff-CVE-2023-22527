package io.netty.handler.codec.serialization;

@Deprecated
public interface ClassResolver {
  Class<?> resolve(String paramString) throws ClassNotFoundException;
}
