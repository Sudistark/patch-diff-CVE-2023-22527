package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.util.JacksonFeature;

public interface FormatFeature extends JacksonFeature {
  boolean enabledByDefault();
  
  int getMask();
  
  boolean enabledIn(int paramInt);
}
