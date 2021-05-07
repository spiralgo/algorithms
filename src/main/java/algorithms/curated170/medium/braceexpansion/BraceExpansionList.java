package algorithms.curated170.medium.braceexpansion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BraceExpansionList {
  public static String[] expand(String S) {
    int n = S.length();
    if (n == 0) {
      return new String[] { "" };
    }
    if (n == 1) {
      return new String[] { S };
    }

    List<String> res = new ArrayList<>();
    if (S.charAt(0) == '{') {
      int i = 0;
      while (i < S.length()) {
        if (S.charAt(i) == '}') {
          break;
        }
        i++;
      }
      String[] leftStrs = S.substring(1, i).split(",");
      String[] rightStrs = expand(S.substring(i + 1));
      for (String lStr : leftStrs) {
        for (String rStr : rightStrs) {
          res.add(lStr + rStr);
        }
      }
    } else {
      String[] rightStrs = expand(S.substring(1));
      for (String rStr : rightStrs) {
        res.add(S.charAt(0) + rStr);
      }
    }
    Collections.sort(res);
    return res.toArray(new String[0]);
  }

  public static void main(String[] args) {
    var strs = expand("{a,b}c{d,e}f");
    System.out.println(Arrays.toString(strs)); // prints [acdf, acef, bcdf, bcef]
  }
}
