package co.pragmati.function.throwing;

import org.junit.Test;

public class ThrowingBiFunctionTest {

    @Test
    public void runSuccessfully() {
        ThrowingBiFunction<String, String, String, UnsupportedOperationException> c = (a, b) -> a + "-" + b;
        c.apply("test", "test");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void throwUnsupportedOperationException() {
        ThrowingBiFunction<String, String, String, UnsupportedOperationException> c = (a, b) -> { throw new UnsupportedOperationException(); };
        c.apply("test", "test");
    }
}
