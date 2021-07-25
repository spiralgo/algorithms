package algorithms.curated170.hard;

public class StringTransformsIntoAnotherString {
    
    public boolean canConvert(String s1, String s2) {
        if (s1.equals(s2))
            return true;

        char[] conversions = new char[26];
        var hasChar = new boolean[26];
        int charCount = 0;

        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i), c2 = s2.charAt(i);
            if (conversions[letterIdx(c1)] != 0 && conversions[letterIdx(c1)] != c2) {
                return false;
            }
            
            conversions[letterIdx(c1)] = c2;
            
            if (!hasChar[letterIdx(c2)]) {
                hasChar[letterIdx(c2)] = true;
                charCount++;
            }

        }
        return charCount < 26;
    }

    private int letterIdx(char c) {
        return c - 'a';
    }

}
