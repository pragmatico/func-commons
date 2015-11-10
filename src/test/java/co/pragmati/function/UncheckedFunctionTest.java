package co.pragmati.function;

import org.junit.Test;

public class UncheckedFunctionTest {

    @Test(expected = RuntimeException.class)
    public void throwRuntimeException() {
        UncheckedFunction<String, String> f = s -> { throw new UnsupportedOperationException(); };
        f.apply("test");
    }

}
