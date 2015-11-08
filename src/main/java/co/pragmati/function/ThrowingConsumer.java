package co.pragmati.function;

import java.util.Objects;
import java.util.function.Consumer;

/**
 * Consumer that throws unchecked exceptions
 *
 * @param <T>
 * @author jmbataller
 */
@FunctionalInterface
public interface ThrowingConsumer<T> extends Consumer<T> {

    /**
     * Performs this operation on the given argument.
     *
     * @param t the input argument
     */
    @Override
    default void accept(T t) {
        try {
            applyThrows(t);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * Performs operation on the given parameter
     *
     * @param t
     * @throws Exception
     */
    void applyThrows(T t) throws Exception;

    default ThrowingConsumer<T> andThen(ThrowingConsumer<? super T> after) {
        Objects.requireNonNull(after);
        return (T t) -> {
            accept(t);
            after.accept(t);
        };
    }
}
