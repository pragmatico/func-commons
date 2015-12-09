package co.pragmati.function.unchecked;

import java.util.Objects;
import java.util.function.Function;

/**
 * BiFunction that throws exceptions
 * @param <T>
 * @param <U>
 * @param <R>
 *
 * @author jmbataller
 */
@FunctionalInterface
public interface UncheckedBiFunction<T, U, R> {

    R applyThows(T t, U u) throws Exception;

    default R apply(T t, U u) {
        try {
            return applyThows(t, u);
        } catch (RuntimeException e) {
            throw e;
        } catch (java.lang.Exception e) {
            throw new RuntimeException(e);
        }
    }

    default <V> UncheckedBiFunction<T, U, V> andThen(Function<? super R, ? extends V> after) {
        Objects.requireNonNull(after);
        return (T t, U u) -> after.apply(applyThows(t, u));
    }
}
