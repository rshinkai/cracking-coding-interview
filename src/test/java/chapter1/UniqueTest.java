package chapter1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UniqueTest {
    @Test
    public void success() {
        Unique sut = new Unique();
        assertTrue(sut.isUnique("abcde"));
        assertFalse(sut.isUnique("abcdea"));
    }
}
