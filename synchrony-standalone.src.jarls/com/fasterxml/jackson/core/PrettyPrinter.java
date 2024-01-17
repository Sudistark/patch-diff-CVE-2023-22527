package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.io.SerializedString;
import com.fasterxml.jackson.core.util.Separators;
import java.io.IOException;

public interface PrettyPrinter {
  public static final Separators DEFAULT_SEPARATORS = Separators.createDefaultInstance();
  
  public static final SerializedString DEFAULT_ROOT_VALUE_SEPARATOR = new SerializedString(" ");
  
  void writeRootValueSeparator(JsonGenerator paramJsonGenerator) throws IOException;
  
  void writeStartObject(JsonGenerator paramJsonGenerator) throws IOException;
  
  void writeEndObject(JsonGenerator paramJsonGenerator, int paramInt) throws IOException;
  
  void writeObjectEntrySeparator(JsonGenerator paramJsonGenerator) throws IOException;
  
  void writeObjectFieldValueSeparator(JsonGenerator paramJsonGenerator) throws IOException;
  
  void writeStartArray(JsonGenerator paramJsonGenerator) throws IOException;
  
  void writeEndArray(JsonGenerator paramJsonGenerator, int paramInt) throws IOException;
  
  void writeArrayValueSeparator(JsonGenerator paramJsonGenerator) throws IOException;
  
  void beforeArrayValues(JsonGenerator paramJsonGenerator) throws IOException;
  
  void beforeObjectEntries(JsonGenerator paramJsonGenerator) throws IOException;
}
