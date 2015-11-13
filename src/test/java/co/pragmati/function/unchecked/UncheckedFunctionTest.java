package co.pragmati.function.unchecked;

import org.junit.Test;

public class UncheckedFunctionTest {

    @Test
    public void runSuccessfully() {
        UncheckedFunction<String, String> f = s -> { return "ok"; };
        f.apply("test");
    }

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
