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

      public int assignBikes(int[][] workers, int[][] bikes) {

            this.workers = workers;
            this.bikes = bikes;
            targetBitmask = (1 << workers.length) - 1;

            int[][] visited = new int[bikes.length][1 << workers.length];
            return dfs(visited, 0, 0);
      }

      private int dfs(int[][] visited, int workerAssigned, int bikePos) {
            if (workerAssigned == targetBitmask)
                  return 0;

            if (bikePos == bikes.length)
                  return Integer.MAX_VALUE;

            if (visited[bikePos][workerAssigned] != 0)
                  return visited[bikePos][workerAssigned];

            long best = dfs(visited, workerAssigned, bikePos + 1);

            for (int i = 0; i < workers.length; i++) {
                  if ((workerAssigned & (1 << i)) == 0) {
                        long cost = dist(i, bikePos);
                        best = Math.min(best, cost + dfs(visited, workerAssigned | (1 << i), bikePos + 1));
                  }
            }

            visited[bikePos][workerAssigned] = (best >= Integer.MAX_VALUE) ? Integer.MAX_VALUE : (int) best;
            System.out.println(Arrays.toString(visited[0]));
            return visited[bikePos][workerAssigned];
      }

      public static void main(String[] args) {
            System.out.println(Arrays.deepToString(leetCodeIntegerGridConverter("[[15,0],[2,2],[2,1]]")));
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