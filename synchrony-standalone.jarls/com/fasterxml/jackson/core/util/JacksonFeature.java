package com.fasterxml.jackson.core.util;

public interface JacksonFeature {
  boolean enabledByDefault();
  
  int getMask();
  
  boolean enabledIn(int paramInt);
}
