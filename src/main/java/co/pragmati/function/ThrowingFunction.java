package co.pragmati.function;

import java.util.Objects;
import java.util.function.Function;

/**
 * Function that throws unchecked exceptions
 *
 * @param <T>
 * @param <R>
 * @author jmbataller
 */
@FunctionalInterface
public interface ThrowingFunction<T, R> extends Function<T, R> {

    @Override
    default R apply(T t) {
        try {
            return applyThrows(t);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * apply that throws Exception
     *
     * @param t
     * @return
     * @throws Exception
     */
    R applyThrows(T t) throws Exception;

    /**
     * andThen operator
     *
     * @param after
     * @param <V>
     * @return
     */
    default <V> ThrowingFunction<T, V> andThen(ThrowingFunction<? super R, ? extends V> after) {
        Objects.requireNonNull(after);
        try {
            return (T t) -> after.apply(apply(t));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

