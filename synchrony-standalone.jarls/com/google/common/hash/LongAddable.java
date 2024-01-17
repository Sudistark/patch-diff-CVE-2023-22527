package com.google.common.hash;

@ElementTypesAreNonnullByDefault
interface LongAddable {
  void increment();
  
  void add(long paramLong);
  
  long sum();
}
