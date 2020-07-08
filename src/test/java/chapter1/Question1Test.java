package chapter1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Question1Test {
    @Test
    public void success() {
        Question1 sut = new Question1();
        assertTrue(sut.isUnique("abcde"));
        assertFalse(sut.isUnique("abcdea"));
    }
}
