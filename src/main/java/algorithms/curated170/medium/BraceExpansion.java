package algorithms.curated170.medium;

import java.util.Arrays;
import java.util.TreeSet;

public class BraceExpansion {
    public static String[] expand(String S) {
        TreeSet<String> set = new TreeSet<>();
        if (S.length() == 0) {
            return new String[] { "" };
        } else if (S.length() == 1) {
            return new String[] { S };
        }

        if (S.charAt(0) == '{') {
            int i = 0;
            while (S.charAt(i) != '}') {
                i++;
            }
            String sub = S.substring(1, i);
            String[] subs = sub.split(",");
            String[] strs = expand(S.substring(i + 1)); 
            for (int j = 0; j < subs.length; j++) {
                for (String str : strs) {
                    set.add(subs[j] + str);
                }
            }
        } else {
            String[] strs = expand(S.substring(1));
            for (String str : strs) {
                set.add(S.charAt(0) + str);
            }
        }
        return set.toArray(new String[0]);
    }

    public static void main(String[] args) {
        var strs = expand("{a,b}c{d,e}f");
        System.out.println(Arrays.toString(strs)); //prints [acdf, acef, bcdf, bcef]
    }
}
