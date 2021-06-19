package algorithms.curated170.medium;

public class OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();

        if (sLen > tLen) {
            return isOneEditDistance(t, s);
        }

        if (tLen - sLen > 1) {
            return false;
        }

        for (int i = 0; i < sLen; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (sLen == tLen) {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                }
                else {
                    return s.substring(i).equals(t.substring(i + 1));
                }
            }
        }

        return (sLen + 1 == tLen);
    }
}
