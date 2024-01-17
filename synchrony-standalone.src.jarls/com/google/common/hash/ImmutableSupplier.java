package com.google.common.hash;

import com.google.common.base.Supplier;
import com.google.errorprone.annotations.Immutable;

@Immutable
@ElementTypesAreNonnullByDefault
interface ImmutableSupplier<T> extends Supplier<T> {}
