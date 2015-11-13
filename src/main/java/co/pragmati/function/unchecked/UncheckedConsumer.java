package co.pragmati.function.unchecked;

import java.util.function.Consumer;

/**
 * Consumer that throws unchecked exceptions
 *
 * @param <T>
 */
@FunctionalInterface
public interface UncheckedConsumer<T> extends Consumer<T> {

    @Override
    default void accept(T t) {
        try {
            acceptThrows(t);
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    void acceptThrows(T t) throws Exception;
}
