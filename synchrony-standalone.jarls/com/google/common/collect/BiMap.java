package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
@GwtCompatible
public interface BiMap<K, V> extends Map<K, V> {
  @CheckForNull
  @CanIgnoreReturnValue
  V put(@ParametricNullness K paramK, @ParametricNullness V paramV);
  
  @CheckForNull
  @CanIgnoreReturnValue
  V forcePut(@ParametricNullness K paramK, @ParametricNullness V paramV);
  
  void putAll(Map<? extends K, ? extends V> paramMap);
  
  Set<V> values();
  
  BiMap<V, K> inverse();
}
