package co.pragmati.function;

import org.junit.Test;

public class ThrowingFunctionTest {

    @Test(expected = UnsupportedOperationException.class)
    public void throwUnsupportedOperationException() {
        ThrowingFunction<String, String, UnsupportedOperationException> f = s -> { throw new UnsupportedOperationException(); };
        f.apply("test");
    }
}
