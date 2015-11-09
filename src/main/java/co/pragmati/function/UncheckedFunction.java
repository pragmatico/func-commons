package co.pragmati.function;

import java.util.function.Function;

/**
 * Function that throws unchecked exceptions
 *
 * @param <T>
 * @param <R>
 * @author jmbataller
 */
@FunctionalInterface
public interface UncheckedFunction<T, R> extends Function<T, R> {

    @Override
    default R apply(T t) {
        try {
            return applyThrows(t);
        } catch(RuntimeException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    R applyThrows(T t) throws Exception;
}

