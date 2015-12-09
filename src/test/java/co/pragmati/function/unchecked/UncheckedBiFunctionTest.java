package co.pragmati.function.unchecked;

import org.junit.Test;

public class UncheckedBiFunctionTest {

    @Test
    public void runSuccessfully() throws Exception {
        UncheckedBiFunction<String, String, String> c = (a, b) -> a + "-" + b;
        c.apply("test", "test");
    }

    @Test(expected = RuntimeException.class)
    public void throwRuntimeException() {
        UncheckedBiFunction<String, String, String> c = (a, b) -> { throw new UnsupportedOperationException(); };
        c.apply("test", "test");
    }
}
