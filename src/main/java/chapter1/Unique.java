package chapter1;

public class Unique {
    /**
     * Assume str is ASCII string, so 128 characters
     * TimeComplexity: O(n)
     * Other Solutions
     * 1. Compare every character of the string to every other character of the string.
     * 2. sort the string in O(n log(n)) time and then linearly check the string for neighboring characters that are identical.
     */
    public boolean isUnique(String str) {
        if (str.length() > 128) return false;

        boolean[] charSet = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if(charSet[val]) {
                return false;
            }
            charSet[val] = true;
        }

        return true;
    }
}
