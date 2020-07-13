package chapter1;

public class StringCompression {
    // bad solution
    public String compressBad(String S) {
        String compressBadString = "";
        int countConsecutive = 0;
        for (int i = 0; i < S.length(); i++) {
            countConsecutive++;

            if (i + 1 > S.length() || S.charAt(i) != S.charAt(i + 1)) {
                compressBadString += "" + S.charAt(i) + countConsecutive;
                countConsecutive = 0;
            }
        }
        return compressBadString.length() < S.length() ? compressBadString : S;
    }

    // optimal solution
    public String compress(String S) {
        int finalLength = countCompression(S);
        if (finalLength >= S.length()) return S;

        StringBuilder compressed = new StringBuilder(finalLength); // initial capacity
        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            count++;

            if (i + 1 > S.length() || S.charAt(i) != S.charAt(i + 1)) {
                compressed.append(S.charAt(i));
                compressed.append(count);
                count = 0;
            }
        }
        return compressed.toString();
    }

    private int countCompression(String S) {
        int compressedLength = 0;
        int count = 0;

        for (int i = 0; i < S.length(); i++) {
            count++;

            if (i + 1 > S.length() || S.charAt(i) != S.charAt(i + 1)) {
                compressedLength += 1 + String.valueOf(count).length();
                count = 0;
            }
        }
        return compressedLength;
    }
}
