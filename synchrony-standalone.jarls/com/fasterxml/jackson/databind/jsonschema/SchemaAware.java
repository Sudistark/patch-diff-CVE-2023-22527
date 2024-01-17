package com.fasterxml.jackson.databind.jsonschema;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.lang.reflect.Type;

@Deprecated
public interface SchemaAware {
  JsonNode getSchema(SerializerProvider paramSerializerProvider, Type paramType) throws JsonMappingException;
  
  JsonNode getSchema(SerializerProvider paramSerializerProvider, Type paramType, boolean paramBoolean) throws JsonMappingException;
}
