package algorithms.curated170.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import algorithms.util.leetcode.LCArrayConverter;

public class CampusBikes2 {

      private int dist(int wPos, int bPos) {
            return Math.abs(workers[wPos][0] - bikes[bPos][0]) + Math.abs(workers[wPos][1] - bikes[bPos][1]);
      }

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
            int[][] workers = LCArrayConverter.leetCodeIntegerGridConverter("[[1,1],[1,3],[1,5],[4,5]]");
            int[][] bikes = LCArrayConverter.leetCodeIntegerGridConverter("[[4,2],[2,2],[3,5],[5,1]]");

            int sol = solution.assignBikes(workers, bikes);
            System.out.println(sol);
      }
}