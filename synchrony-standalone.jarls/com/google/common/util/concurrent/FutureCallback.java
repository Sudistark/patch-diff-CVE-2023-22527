package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;

@ElementTypesAreNonnullByDefault
@GwtCompatible
public interface FutureCallback<V> {
  void onSuccess(@ParametricNullness V paramV);
  
  void onFailure(Throwable paramThrowable);
}
