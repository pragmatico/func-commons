package co.pragmati.function;

import org.junit.Test;

public class ThrowingFunctionTest {

    @Test(expected = UnsupportedOperationException.class)
    public void throwUnsupportedOperationException() {
        ThrowingFunction<String, String, UnsupportedOperationException> f = s -> { throw new UnsupportedOperationException(); };
        f.apply("test");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void andThenThrowUnsupportedOperationException() {
        ThrowingFunction<String, String, UnsupportedOperationException> func = s -> { return s.toString(); };
        ThrowingFunction<String, String, UnsupportedOperationException> funcThrows = s -> { throw new UnsupportedOperationException(); };
        func.andThen(funcThrows).apply("test");
    }
}
