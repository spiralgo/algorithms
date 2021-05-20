package algorithms.curated170.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CampusBikes2 {

      private int dist(int wPos, int bPos) {
            return Math.abs(workers[wPos][0] - bikes[bPos][0]) + Math.abs(workers[wPos][1] - bikes[bPos][1]);
      }

      private int targetBitmask;
      int[][] workers, bikes;
      int[] dp;

      public int assignBikes(int[][] workers, int[][] bikes) {
            dp = new int[1<<bikes.length];
            
            this.workers = workers;
            this.bikes = bikes;
            return DFS(0, (1<<bikes.length) - 1);
      }

      private int DFS(int worker, int mask)
      {
            if(worker == workers.length)
            {
                  return 0;
            }
            if(dp[mask] != 0)
            {
                  return dp[mask];
            }
            int ans = Integer.MAX_VALUE;
            for(int j = 0; j<bikes.length; j++)
            {
                  if(( mask & (1<<j) )!= 0)
                  {
                        ans = Math.min(ans, dist(worker, j) + DFS(worker+1, mask^(1<<j)));
                  }
            }
            return dp[mask] = ans;
      }
      public static void main(String[] args) {

            var solution = new CampusBikes2();
            int[][] workers = leetCodeIntegerGridConverter("[[1,1],[1,3],[1,5],[4,5]]");
            int[][] bikes = leetCodeIntegerGridConverter("[[4,2],[2,2],[3,5],[5,1]]");

            int sol = solution.assignBikes(workers, bikes);
            System.out.println(sol);
      }

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