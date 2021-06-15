package algorithms.curated170.medium.reversewordsinastring2;

import java.util.Arrays;
import java.util.Collections;

public class ReverseWordsInAString2Builtin {
    
    public void reverseWords(char[] s) {
        String[] words = new String(s).split(" ");
        Collections.reverse(Arrays.asList(words));
        char[] reversed = String.join(" ", words).toCharArray();
        for (int i = 0; i < s.length; i++) {
            s[i] = reversed[i];
        }
    }

}
