package algorithms.util.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LCArrayConverter {

      public static int[][] leetCodeIntegerGridConverter(String arr) {
            List<List<Integer>> list = new ArrayList<>();

            List<Integer> currAr = new ArrayList<>();
            char prev = '#';
            int num = 0;
            boolean inNum = false;
            for (char c : arr.toCharArray()) {
                  if (!Character.isDigit(c) && inNum) {
                        currAr.add(num);
                        num = 0;
                        inNum = false;
                  }
                  if (c == '[') {
                        currAr = new ArrayList<Integer>();
                  } else if (Character.isDigit(c)) {
                        num = num * 10 + Character.getNumericValue(c);
                        inNum = true;
                  } else if (c == ']' && prev != c) {
                        list.add(currAr);
                  }
                  prev = c;
            }
            System.out.println(list);
            Integer[][] arrayBase = list.stream().map(l -> l.stream().toArray(Integer[]::new))
                        .toArray(Integer[][]::new);
            int[][] ret = new int[arrayBase.length][arrayBase[0].length];
            for (int i = 0; i < arrayBase.length; i++) {
                  for (int j = 0; j < arrayBase[0].length; j++) {
                        ret[i][j] = arrayBase[i][j];
                  }
            }
            return ret;
      }
}