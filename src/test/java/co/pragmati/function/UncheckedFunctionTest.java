package co.pragmati.function;

import org.junit.Test;

public class UncheckedFunctionTest {

    @Test(expected = RuntimeException.class)
    public void throwRuntimeException() {
        UncheckedFunction<String, String> f = s -> { throw new UnsupportedOperationException(); };
        f.apply("test");
    }

    @Test(expected = RuntimeException.class)
    public void AndThenthrowRuntimeException() {
        UncheckedFunction<String, String> func = s -> { return s; };
        UncheckedFunction<String, String> funcThrows = s -> { throw new UnsupportedOperationException(); };
        func.andThen(funcThrows).apply("test");
    }
}
