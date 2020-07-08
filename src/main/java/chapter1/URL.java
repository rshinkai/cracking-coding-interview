package chapter1;

public class URL {
    public static void replaceSpaces(String str, int trueLength) {
        int spaceCount = 0;
        int index = 0;
        char[] chars = str.toCharArray();
        for (int i = 0; i < trueLength; i++) {
            if (chars[i] == ' '){
                spaceCount++;
            }
        }
        index = trueLength + spaceCount * 2;
        if (trueLength < str.length()) chars[trueLength] = '\0';
        for (int i = trueLength - 1; i >= 0; i--) {
            if (chars[i] == ' ') {
                chars[index - 1] = '0';
                chars[index - 2] = '2';
                chars[index - 3] = '%';
                index -= 3;
            } else {
                chars[index - 1] = chars[i];
                index--;
            }
        }
    }
}
