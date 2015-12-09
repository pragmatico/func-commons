package co.pragmati.function.unchecked;

/**
 * Predictate that throws unchecked exceptions
 * @param <T>
 *
 * @author jmbataller
 */
@FunctionalInterface
public interface UncheckedPredicate<T> {

    boolean testThrows(T t) throws Exception;

    default boolean test(T t) {
        try {
            return testThrows(t);
        } catch (RuntimeException e) {
            throw e;
        } catch (java.lang.Exception e) {
            throw new RuntimeException(e);
        }
    }
}
