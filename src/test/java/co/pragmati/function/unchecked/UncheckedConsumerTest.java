package co.pragmati.function.unchecked;

import org.junit.Test;

public class UncheckedConsumerTest {

    @Test
    public void runSuccessfully() {
        UncheckedConsumer<String> c = System.out::println;
        c.accept("test");
    }

    @Test(expected = RuntimeException.class)
    public void throwRuntimeException() {
        UncheckedConsumer<String> c = s -> { throw new UnsupportedOperationException(); };
        c.accept("test");
    }
}
