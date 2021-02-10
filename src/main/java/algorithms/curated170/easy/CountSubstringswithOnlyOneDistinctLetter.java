package algorithms.curated170.easy;

public class CountSubstringswithOnlyOneDistinctLetter {
public int countLetters(String S) {
        int total = 1, count = 1;
        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i) == S.charAt(i-1)) {
                count++;
            } else {
                count = 1;
            }
            total += count;
        }
        return total;
    }    
}
