package algorithms.curated170.easy.palindromepermutation;

public class PalindromePermutationBoolean {

    public boolean canPermutePalindrome(String s) {
       
        if (s == null || s.length() == 0) {
            return true;
        }
        int[] map = new int[128];
        
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)]++;
        }

        boolean sawSingle = false;
        for (int key = 0; key < map.length; key++) {
            if (map[key] % 2 == 1) {
                if (sawSingle) {
                    return false;
                }
                sawSingle = true;
            }
        }
        return true;

    }
}
