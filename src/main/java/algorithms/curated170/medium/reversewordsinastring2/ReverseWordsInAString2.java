package algorithms.curated170.medium.reversewordsinastring2;

public class ReverseWordsInAString2 {
    
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length - 1);

        reverseEachWord(s);
    }

    private void reverseEachWord(char[] s) {
        for (int wordStart = 0, j = 0; j <= s.length; j++) {
            if (j == s.length || s[j] == ' ') {
                reverse(s, wordStart, j - 1);
                wordStart = j + 1;
            }
        }
    }

    private void reverse(char[] s, int i, int j) {
        while (i < j) {
            char tmp = s[i];
            s[i++] = s[j];
            s[j--] = tmp;
        }
    }
}
