package algorithms.curated170.medium.reversewordsinastring;

import java.util.Arrays;
import java.util.Collections;

public class ReverseWordsInAStringBuiltin {
    
    public void reverseWords(char[] s) {
        String[] words = new String(s).split(" ");
        Collections.reverse(Arrays.asList(words));
        char[] reversed = String.join(" ", words).toCharArray();
        for (int i = 0; i < s.length; i++) {
            s[i] = reversed[i];
        }
    }

}
