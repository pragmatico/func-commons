package co.pragmati.function.throwing;

import java.util.Objects;
import java.util.function.BiConsumer;

/**
 * BiConsumer that throws exceptions
 * @param <T>
 * @param <U>
 * @param <E>
 *
 * @author jmbataller
 */
@FunctionalInterface
public interface ThrowingBiConsumer<T, U, E extends Throwable> {

    void accept(T t, U u) throws E;

    default ThrowingBiConsumer<T, U, E> andThen(ThrowingBiConsumer<? super T, ? super U, ? extends E> after) {
        Objects.requireNonNull(after);

        return (l, r) -> {
            accept(l, r);
            after.accept(l, r);
        };
    }

    default ThrowingBiConsumer<T, U, E> andThen(BiConsumer<? super T, ? super U> after) {
        Objects.requireNonNull(after);

        return (l, r) -> {
            accept(l, r);
            after.accept(l, r);
        };
    }
}
