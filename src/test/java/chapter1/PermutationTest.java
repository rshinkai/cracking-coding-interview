package chapter1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PermutationTest {
    @Test
    public void success() {
        Permutation sut = new Permutation();
        assertTrue(sut.isPermutation("abcde", "edcba"));
        assertTrue(sut.isPermutation2("abcde", "edcba"));
        assertFalse(sut.isPermutation("abcde", "adcba"));
        assertFalse(sut.isPermutation2("abcde", "adcba"));
    }
}
