package co.pragmati.function.throwing;

import java.util.Objects;
import java.util.function.Consumer;

/**
 * Consumer that throws exceptions
 * @param <T>
 * @param <E>
 *
 * @author jmbataller
 */
@FunctionalInterface
interface ThrowingConsumer<T, E extends Throwable> {

    /**
     * Performs operation on the given argument
     *
     * @param t
     * @throws E
     */
    void accept(T t) throws E;

    default ThrowingConsumer<T, E> andThen(ThrowingConsumer<? super T, ? extends E> after) {
        Objects.requireNonNull(after);
        return (T t) -> {
            accept(t);
            after.accept(t);
        };
    }

    default ThrowingConsumer<T, E> andThen(Consumer<? super T> after) throws E {
        Objects.requireNonNull(after);
        return (T t) -> {
            accept(t);
            after.accept(t);
        };
    }
}