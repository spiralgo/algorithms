package algorithms.curated170.medium.zigzagiterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ZigzagIteratorScaleable { //Can also be called CircularIterator

      List<List<Integer>> lists = new ArrayList<>();
      int p = 0; // which list
      int q = 0; // current index in current list;
      int rows = 0;

      public ZigzagIteratorScaleable(List<Integer> v1, List<Integer> v2) {
            lists.add(v1);
            lists.add(v2);
            rows = lists.size();
      }

      public int next() {
            int val = -1;

            if (hasNext()) {
                  val = lists.get(p).get(q);
                  incrementPointers();
            }

            return val;
      }

      public boolean hasNext() {

            if (lists.get(p).size() > q) {
                  return true;
            }
            countError.add(p);
            if (incrementPointers()) {
                  return hasNext();
            }
            return false;

      }

      HashSet<Integer> countError = new HashSet<>();

      boolean incrementPointers() {
            if (countError.size() < rows) {

                  if (++p == rows) {
                        p = 0;
                        q++;
                  }
                  return true;
            }
            return false;
      }
      public void append(List<Integer> extra) {
            lists.add(extra);
            rows = lists.size();
        }



      public static void main(String[] args) {
            List<Integer> v1 = Arrays.asList(1, 6, 11), v2 = Arrays.asList(2, 7, 12), v3 = Arrays.asList(3, 8),
                        v4 = Arrays.asList(4, 9, 13, 15), v5 = Arrays.asList(5, 10, 14, 16);
                        ZigzagIteratorScaleable z = new ZigzagIteratorScaleable(v1, v2);
            z.append(v3);
            z.append(v4);
            z.append(v5);

            int val;
            do {
                  val = z.next();
                  System.out.println(val);
            } while (val > -1);
      }

}