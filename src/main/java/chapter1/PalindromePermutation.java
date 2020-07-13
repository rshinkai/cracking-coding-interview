package chapter1;

public class PalindromePermutation {
    // use a hash table to count how many times each character appears.
    // Then, iterate through the hash table and ensure that no more than one character has an odd count.
    public boolean solution1(String phrase) {
        int[] table = buildCharFrequencyTable(phrase);
        return checkMaxOneOdd(table);
    }

    private boolean checkMaxOneOdd(int[] table) {
        boolean foundOdd = false;
        for (int count: table) {
            if (count % 2 == 1) {
                if (foundOdd) {
                    return false;
                }
                foundOdd = true;
            }
        }
        return true;
    }

    private int[] buildCharFrequencyTable(String phrase) {
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for (char c: phrase.toCharArray()) {
            int x = getCharNumber(c);
            if (x != -1) {
                table[x]++;
            }
        }
        return table;
    }

    private int getCharNumber(Character c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if (a <= val && val <= z) {
            return val - a;
        }
        return -1;
    }

    // solution 2
    // Instead of checking the number of odd counts at the end, check as we go along.
    public boolean solution2(String phrase) {
        int countOdd = 0;
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for (char c: phrase.toCharArray()) {
            int x = getCharNumber(c);
            if (x != -1) {
                table[x]++;
                if (table[x] % 2 == 1) {
                    countOdd++;
                } else {
                    countOdd--;
                }
            }
        }
        return countOdd <= 1;
    }

    // solution 3
    public boolean solution3(String phrase) {
        int bitVector = createVector(phrase);
        return bitVector == 0 || checkExactlyOneBitSet(bitVector);
    }

    private int createVector(String phrase) {
        int bitVector = 0;
        for (char c: phrase.toCharArray()){
            int x = getCharNumber(c);
            bitVector = toggle(bitVector, x);
        }
        return bitVector;
    }

    private int toggle(int bitVector, int index) {
        if (index < 0) return bitVector;

        int mask = 1 << index;
        if ((bitVector & mask) == 0) {
            bitVector |= mask;
        } else {
            bitVector &= ~mask;
        }
        return bitVector;
    }

    private boolean checkExactlyOneBitSet(int bitVector) {
        return (bitVector & (bitVector - 1)) == 0;
    }
}
