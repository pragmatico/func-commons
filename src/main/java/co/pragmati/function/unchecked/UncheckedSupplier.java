package co.pragmati.function.unchecked;


/**
 * Supplier with unchecked exception
 * @param <T>
 *
 * @author jmbataller
 */
@FunctionalInterface
public interface UncheckedSupplier<T> {

    T getThrows() throws Exception;

    default T get() throws Exception {
        try {
            return getThrows();
        } catch (RuntimeException e) {
            throw e;
        } catch (java.lang.Exception e) {
            throw new RuntimeException(e);
        }
    }
}