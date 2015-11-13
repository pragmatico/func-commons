package co.pragmati.function.throwing;

import org.junit.Test;

public class ThrowingConsumerTest {

    @Test
    public void runSuccessfully() {
        ThrowingConsumer<String, UnsupportedOperationException> c = System.out::println;
        c.accept("test");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void throwUnsupportedOperationException() {
        ThrowingConsumer<String, UnsupportedOperationException> c = s -> { throw new UnsupportedOperationException(); };
        c.accept("test");
    }
}
