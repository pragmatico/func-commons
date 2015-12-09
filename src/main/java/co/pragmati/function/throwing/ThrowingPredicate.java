package co.pragmati.function.throwing;

import java.util.Objects;

/**
 * Predictate that throws exceptions
 * @param <T>
 * @param <E>
 *
 * @author jmbataller
 */
@FunctionalInterface
public interface ThrowingPredicate<T, E extends Throwable> {

    boolean test(T t) throws E;

    default ThrowingPredicate<T, E> and(ThrowingPredicate<? super T, E> other) throws E {
        Objects.requireNonNull(other);
        return (t) -> test(t) && other.test(t);
    }

}
