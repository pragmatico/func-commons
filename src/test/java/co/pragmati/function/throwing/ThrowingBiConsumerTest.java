package co.pragmati.function.throwing;

import org.junit.Test;

public class ThrowingBiConsumerTest {

    @Test
    public void runSuccessfully() {
        ThrowingBiConsumer<String, String, UnsupportedOperationException> c = (a, b) -> System.out.println(a + "-" + b);
        c.accept("test", "test");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void throwUnsupportedOperationException() {
        ThrowingBiConsumer<String, String, UnsupportedOperationException> c = (a, b) -> { throw new UnsupportedOperationException(); };
        c.accept("test", "test");
    }
}
