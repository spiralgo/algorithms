package algorithms;

import java.util.HashMap;

public class RomantoInteger {

    static HashMap<Character, Integer> hm = new HashMap<>();

    public static void main(String[] args) {
        RomantoInteger ri = new RomantoInteger();

        hm.put('I', 1);
        hm.put('V', 5);
        hm.put('X', 10);
        hm.put('L', 50);
        hm.put('C', 100);
        hm.put('D', 500);
        hm.put('M', 1000);

        String s = "MMCDXXV";
        int output = ri.romanToInt(s);
        System.out.println(output);
    }

    public int romanToInt(String s) {
        int total = 0;
        int last = hm.get(s.charAt(s.length()-1));
        for (int i = 0; i < s.length() - 1; i++) {
            int char1 = hm.get(s.charAt(i));
            int char2 = hm.get(s.charAt(i + 1));
          
            if (char1 >= char2) {
                System.out.println("+");
                total = total + char1;
            } else if (char1 < char2) {
                System.out.println("-");
                total = total - char1;
            }
            
        }
        total = total + last;
        return total;

    }
}
