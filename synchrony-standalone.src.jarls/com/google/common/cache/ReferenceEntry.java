package com.google.common.cache;

import com.google.common.annotations.GwtIncompatible;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
interface ReferenceEntry<K, V> {
  @CheckForNull
  LocalCache.ValueReference<K, V> getValueReference();
  
  void setValueReference(LocalCache.ValueReference<K, V> paramValueReference);
  
  @CheckForNull
  ReferenceEntry<K, V> getNext();
  
  int getHash();
  
  @CheckForNull
  K getKey();
  
  long getAccessTime();
  
  void setAccessTime(long paramLong);
  
  ReferenceEntry<K, V> getNextInAccessQueue();
  
  void setNextInAccessQueue(ReferenceEntry<K, V> paramReferenceEntry);
  
  ReferenceEntry<K, V> getPreviousInAccessQueue();
  
  void setPreviousInAccessQueue(ReferenceEntry<K, V> paramReferenceEntry);
  
  long getWriteTime();
  
  void setWriteTime(long paramLong);
  
  ReferenceEntry<K, V> getNextInWriteQueue();
  
  void setNextInWriteQueue(ReferenceEntry<K, V> paramReferenceEntry);
  
  ReferenceEntry<K, V> getPreviousInWriteQueue();
  
  void setPreviousInWriteQueue(ReferenceEntry<K, V> paramReferenceEntry);
}
