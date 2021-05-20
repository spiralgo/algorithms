package algorithms.curated170.easy.palindromepermutation;

 
public class PalindromePermutationArray {
class Solution {
    public boolean canPermutePalindrome(String s) {
        // 
        if (s == null || s.length() == 0) {
            return true;
        }
        int[] map = new int[128];
        int count = 0;
        for (int i = 0; i < s.length(); i ++) {
            map[s.charAt(i)] ++;
        }
        for (int key = 0; key < map.length; key ++) {
            if (count <= 1) {
                count += map[key] % 2;
            } else {
                break;
            }

        }
        return count <= 1;
    }
}
}
