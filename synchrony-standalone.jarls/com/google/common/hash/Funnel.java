package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.DoNotMock;
import java.io.Serializable;

@DoNotMock("Implement with a lambda")
@ElementTypesAreNonnullByDefault
@Beta
public interface Funnel<T> extends Serializable {
  void funnel(@ParametricNullness T paramT, PrimitiveSink paramPrimitiveSink);
}
