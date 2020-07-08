package chapter1;

import java.util.Arrays;

public class Permutation {
    private String sort(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    // solution 1
    public boolean isPermutation(String S, String T) {
        if (S.length() != T.length()) {
            return false;
        }

        return sort(S).equals(sort(T));
    }

    // solution 2
    // Assume ASCII string
    public boolean isPermutation2(String S, String T) {
        if (S.length() != T.length()) {
            return false;
        }

        int[] letters = new int[128];
        char[] sArray = S.toCharArray();
        for (char c: sArray) {
            letters[c]++;
        }

        for (int i = 0; i < T.length(); i++) {
            int c = T.charAt(i);
            letters[c]--;
            if(letters[c] < 0) {
                return false;
            }
        }

        return true;
    }
}
