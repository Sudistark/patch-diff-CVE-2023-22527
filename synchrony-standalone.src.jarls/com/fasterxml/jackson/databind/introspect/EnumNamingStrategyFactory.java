package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.EnumNamingStrategy;
import com.fasterxml.jackson.databind.util.ClassUtil;

public class EnumNamingStrategyFactory {
  public static EnumNamingStrategy createEnumNamingStrategyInstance(Object namingDef, boolean canOverrideAccessModifiers) {
    if (namingDef == null)
      return null; 
    if (namingDef instanceof EnumNamingStrategy)
      return (EnumNamingStrategy)namingDef; 
    if (!(namingDef instanceof Class))
      throw new IllegalArgumentException(String.format("AnnotationIntrospector returned EnumNamingStrategy definition of type %s; expected type `Class<EnumNamingStrategy>` instead", new Object[] { ClassUtil.classNameOf(namingDef) })); 
    Class<?> namingClass = (Class)namingDef;
    if (namingClass == EnumNamingStrategy.class)
      return null; 
    if (!EnumNamingStrategy.class.isAssignableFrom(namingClass))
      throw new IllegalArgumentException(String.format("Problem with AnnotationIntrospector returned Class %s; expected `Class<EnumNamingStrategy>`", new Object[] { ClassUtil.classNameOf(namingClass) })); 
    return (EnumNamingStrategy)ClassUtil.createInstance(namingClass, canOverrideAccessModifiers);
  }
}
