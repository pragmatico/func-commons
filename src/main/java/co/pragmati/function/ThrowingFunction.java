package co.pragmati.function;

import java.util.Objects;
import java.util.function.Function;

@FunctionalInterface
public interface ThrowingFunction<T, R, E extends Throwable> {

    R apply(T t) throws E;

    default <V> ThrowingFunction<V, R, E> compose(ThrowingFunction<? super V, ? extends T, ? extends E> before) throws E {
        Objects.requireNonNull(before);
        return (V v) -> apply(before.apply(v));
    }

    default <V> ThrowingFunction<T, V, E> andThen(ThrowingFunction<? super R, ? extends V, ? extends E> after) throws E {
        Objects.requireNonNull(after);
        return (T t) -> after.apply(apply(t));
    }

    default <V> ThrowingFunction<V, R, E> compose(Function<? super V, ? extends T> before) throws E {
        Objects.requireNonNull(before);
        return (V v) -> apply(before.apply(v));
    }

    default <V> ThrowingFunction<T, V, E> andThen(Function<? super R, ? extends V> after) throws E {
        Objects.requireNonNull(after);
        return (T t) -> after.apply(apply(t));
    }

    static <T> Function<T, T> identity() {
        return t -> t;
    }

}
