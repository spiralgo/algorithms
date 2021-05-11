package algorithms.curated170.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CampusBikesBucketSort {

      int w;
      List<int[]>[] buckets = new List[2001];

      public int[] assignBikes(int[][] workers, int[][] bikes) {
            
            w = workers.length;

            assignToBuckets(workers, bikes);

            return assignFromBuckets();
      }

      private void assignToBuckets(int[][] workers, int[][] bikes) {
            for (int i = 0; i < w; i++) {
                  for (int j = 0; j < w; j++) {
                        int dis = Math.abs(bikes[j][0] - workers[i][0]) + Math.abs(bikes[j][1] - workers[i][1]);
                        if (buckets[dis] == null) {
                              buckets[dis] = new ArrayList<>();
                        }
                        buckets[dis].add(new int[] { i, j });
                  }
            }
      }

      private int[] assignFromBuckets()
      {
            int[] res = new int[w];
            boolean[] bikeAssigned = new boolean[w];
            boolean[] workerAssigned = new boolean[w];
            short assigned = 0;

            for (int i = 0; i < buckets.length && assigned < w; i++) {
                  if (buckets[i] != null) {
                        for (int[] pair : buckets[i]) {
                              if (!workerAssigned[pair[0]] && !bikeAssigned[pair[1]]) {
                                    res[pair[0]] = pair[1];
                                    bikeAssigned[pair[1]] = true;
                                    workerAssigned[pair[0]] = true;
                                    assigned++;
                              }
                        }
                  }
            }
            return res;
      }

      public static void main(String[] args) {

      }
}