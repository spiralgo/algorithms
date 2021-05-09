package algorithms.curated170.medium.zigzagiterator;

import java.util.ArrayList;
import java.util.List;

public class ZigzagIterator {

      List<List<Integer>> lists = new ArrayList<>();
      int p = 0; // which list
      int q = 0; // current index in current list;

      public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
            lists.add(v1);
            lists.add(v2);

      }

      public int next() {
            int val = lists.get(p).get(q);
            incrementPointers();
            return val;
      }

      public boolean hasNext() {
            if (lists.get(p).size() > q)
                  return true;

            incrementPointers();
            return lists.get(p).size() > q;

      }

      void incrementPointers() {
            p = 1 - p;
            if (p == 0) {
                  q++;
            }
      }

      public static void main(String[] args) {
            var solution = new ZigzagIterator(List.of(1, 2), List.of(3, 4, 5, 6));
            while (solution.hasNext()) {
                  System.out.println(solution.next());
            }
      }

}