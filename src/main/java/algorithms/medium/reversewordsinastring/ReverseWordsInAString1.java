package algorithms.medium.reversewordsinastring;

import java.util.Arrays;

public class ReverseWordsInAString1 {
    public String reverseWords(String words) {
        char[] s = words.toCharArray();
        int length = clearSpaces(s);
        s = Arrays.copyOf(s, length);

        reverse(s, 0, s.length - 1);

        reverseEachWord(s);

        return new String(s);
    }

    private void reverseEachWord(char[] s) {
        for (int wordStart = 0, j = 0; j <= s.length; j++) {
            if (j == s.length || s[j] == ' ') {
                reverse(s, wordStart, j - 1);
                wordStart = j + 1;
            }
        }
    }

    private int clearSpaces(char[] s) {
        int length = 0;
        for (int j = 0; j < s.length; j++) {
            if (s[j] != ' ' || (length > 0 && s[length - 1] != ' ')) {
                s[length++] = s[j];
            }
        }
        if (length > 0 && s[length - 1] == ' ') {
            length--;
        }
        return length;
    }

    private void reverse(char[] s, int i, int j) {
        while (i < j) {
            char tmp = s[i];
            s[i++] = s[j];
            s[j--] = tmp;
        }
    }

}