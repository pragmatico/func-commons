package co.pragmati.function.throwing;

import java.util.Objects;
import java.util.function.Function;

/**
 * BiFunction that throws exceptions
 * @param <T>
 * @param <U>
 * @param <R>
 * @param <E>
 *
 * @author jmbataller
 */
@FunctionalInterface
public interface ThrowingBiFunction<T, U, R, E extends Throwable> {

    R apply(T t, U u) throws E;

    default <V> ThrowingBiFunction<T, U, V, E> andThen(Function<? super R, ? extends V> after) {
        Objects.requireNonNull(after);
        return (T t, U u) -> after.apply(apply(t, u));
    }
}
