package algorithms.curated170.medium.generalizedabbreviation;

import java.util.ArrayList;
import java.util.List;

public class GeneralizedAbbreviationBitwise {
    public List<String> generateAbbreviations(String word) {
        List<String> ans = new ArrayList<>();

        // the key is the binary representation of how many and which chars are converted to digits
        //1100 would show that first two chars are the number 2 now
        for (int key = 0; key < (1 << word.length()); key++)
        {
            ans.add(abbreviate(word, key));
        }
        return ans;
    }

    private String abbreviate(String word, int key) {
        StringBuilder sb = new StringBuilder();
        int count = 0, n = word.length(); // count how may chars are numerized
        for (int i = 0; i < n; i++, key >>= 1) {
            if ((key & 1) == 0) { // if the bit is zero, the char should be kept 
                if (count != 0) { // we have this many abbreviated characters
                    sb.append(count); // we add it as a string to the String Builder
                    count = 0; // reset the count
                }
                sb.append(word.charAt(i));
            }
            else 
            {
                count++; // if it is one, that means we have a digit and should increase the count
            }
        }
        if (count != 0) sb.append(count); // take care as it can trail off at the end: 000111
        return sb.toString();
    }

    public static void main(String[] args) {
        var solution = new GeneralizedAbbreviationBitwise();
        String s = "string";
        var a = solution.generateAbbreviations(s);
        System.out.println(a);
    }
}