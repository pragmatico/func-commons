package co.pragmati.function.unchecked;

import co.pragmati.function.throwing.ThrowingPredicate;
import org.junit.Test;

public class UncheckedPredicateTest {

    @Test
    public void runSuccessfully() {
        UncheckedPredicate<String> f = s -> { return true; };
        f.test("test");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void throwUnsupportedOperationException() {
        ThrowingPredicate<String, UnsupportedOperationException> f = s -> { throw new UnsupportedOperationException(); };
        f.test("test");
    }

}

