package co.pragmati.function.unchecked;

import org.junit.Test;

public class UncheckedBiConsumerTest {

    @Test
    public void runSuccessfully() {
        UncheckedBiConsumer<String, String> c = (a, b) -> System.out.println(a + "-" + b);
        c.accept("test", "test");
    }

    @Test(expected = RuntimeException.class)
    public void throwRuntimeException() {
        UncheckedBiConsumer<String, String> c = (a, b) -> { throw new UnsupportedOperationException(); };
        c.accept("test", "test");
    }
}
