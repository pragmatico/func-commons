package co.pragmati.function.throwing;

import org.junit.Test;

public class ThrowingPredicateTest {

    @Test
    public void runSuccessfully() {
        ThrowingPredicate<String, UnsupportedOperationException> f = s -> { return true; };
        f.test("test");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void throwUnsupportedOperationException() {
        ThrowingPredicate<String, UnsupportedOperationException> f = s -> { throw new UnsupportedOperationException(); };
        f.test("test");
    }

}

