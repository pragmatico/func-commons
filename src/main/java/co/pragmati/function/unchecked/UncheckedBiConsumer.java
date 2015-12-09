package co.pragmati.function.unchecked;

import java.util.function.BiConsumer;

/**
 * BiConsumer that throws unchecked exceptions
 * @param <T>
 * @param <U>
 *
 * @author jmbataller
 */
public interface UncheckedBiConsumer<T, U> extends BiConsumer<T, U> {

    void acceptThrows(T t, U u) throws Exception;

    @Override
    default void accept(T t, U u) {
        try {
            acceptThrows(t, u);
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}