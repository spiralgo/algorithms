package algorithms.curated170.medium;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ZigzagIterator {

      LinkedList<Iterator<Integer>> q;

      public ZigzagIterator(List<Integer>... lists) {
            q = new LinkedList<>();
            for (List<Integer> list : lists) {
                  if (!list.isEmpty()) {
                        q.add(list.iterator());
                  }
            }
      }

      public int next() {
            Iterator<Integer> iter = q.remove();
            int num = iter.next();
            if (iter.hasNext())
            {
                  q.add(iter);
            }
            return num;
      }

      public boolean hasNext() {
            return !q.isEmpty();
      }

      public static void main(String[] args) {
            var solution = new ZigzagIterator(List.of(1,2), List.of(3,4,5,6));
            while(solution.hasNext())
            {
                  System.out.println(solution.next());
      }
}