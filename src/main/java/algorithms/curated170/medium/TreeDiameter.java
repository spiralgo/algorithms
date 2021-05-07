package algorithms.curated170.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreeDiameter {
      private int diameter = 0;
      private Map<Integer, List<Integer>> tree = new HashMap<>();

      public int treeDiameter(int[][] input) {
            int ret = 0;
            for (int[] pair : input) {
                  int a = pair[0];
                  int b = pair[1];
                  tree.putIfAbsent(a, new ArrayList<>());
                  tree.putIfAbsent(b, new ArrayList<>());
                  tree.get(a).add(b);
                  tree.get(b).add(a);
            }
            searchDiameter(tree.keySet().iterator().next(), Integer.MIN_VALUE);
            return diameter;
      }

      public int searchDiameter(int root, int parent) {
            int maxArm1 = 0;
            int maxArm2 = 0;
            for (int k : tree.get(root)) {
                  int depth = 0;
                  if (k != parent) {
                        depth = searchDiameter(k, root);
                        if (depth > maxArm1) {
                              maxArm2 = maxArm1;
                              maxArm1 = depth;
                        } else if (depth > maxArm2) {
                              maxArm2 = depth;
                        }
                        /*
                         * Is this better?
                         * maxArm2 = Math.max(maxArm2, Math.min(maxArm1, depth));
                         * maxArm1 = Math.max(maxArm1, depth);
                         */
                  }
            }
            diameter = Math.max(diameter, maxArm1 + maxArm2);
            return maxArm1 + 1;
      }

      public static void main(String[] args) {

            var solution = new TreeDiameter();
            System.out.println(solution.treeDiameter(
                        new int[][] { { 0, 1 }, { 1, 2 }, { 1, 3 }, { 3, 6 }, { 2, 7 }, { 0, 4 }, { 4, 5 } })); //prints 5
      }
}