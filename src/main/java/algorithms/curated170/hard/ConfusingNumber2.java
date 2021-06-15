package algorithms.curated170.hard;

import algorithms.hard.StrobogrammaticNumber3;

 
public class ConfusingNumber2 {
   final char[][] reflectives = new char[][]{
        {'0', '0'},
        {'6', '9'},
        {'1', '1'},
        {'9', '6'},
        {'8', '8'}
    };

    int highLen;
    int lowLen;
    int currLen;
    
    public int confusingNumberII(int n) {
        String num = Integer.toString(n);
        int res = findTotal(num);
        StrobogrammaticNumber3 strobogrammaticNumber = new StrobogrammaticNumber3();
        return res - strobogrammaticNumber.strobogrammaticInRange("1", num) - 1;
    }
    private int findTotal(String s) {
        if (s.length() == 0) return 1;
        char first = s.charAt(0);
        int res = count(first) * (int) (Math.pow(5, s.length() - 1));
        if (first == '0' || first == '1' || first == '6' || first == '8' || first == '9') {
            res += findTotal(s.substring(1));
        }
        return res;
    }
    private int count(Character c) {
        int res = 0;
        for (char[] p : reflectives) {
            if (p[0] < c) res += 1;
        }
        return res;
    }
    
}
