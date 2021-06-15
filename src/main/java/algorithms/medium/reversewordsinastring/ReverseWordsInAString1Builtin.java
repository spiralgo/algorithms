package algorithms.medium.reversewordsinastring;

import java.util.Arrays;
import java.util.Collections;

public class ReverseWordsInAString1Builtin {
    
    public String reverseWords(String words) {
        String[] s = words.trim().split(" +");
        Collections.reverse(Arrays.asList(s));
        return String.join(" ", s);
    }

}