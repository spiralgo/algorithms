package algorithms.curated170.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class CampusBikesPriorityQueue {

      int w;
      PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                  return a[0] != b[0] ? a[0] - b[0] : (a[1] != b[1] ? a[1] - b[1] : (a[2] - b[2]));
            }
      });

      public int[] assignBikes(int[][] workers, int[][] bikes) {

            w = workers.length;

            createHeap(workers, bikes);

            return assignFromHeap();
      }

      private void createHeap(int[][] workers, int[][] bikes)
      {
            for (int i = 0; i < w; i++) {
                  for (int j = 0; j < w; j++) {
                        int[] worker = workers[i], bike = bikes[j];
                        int dist = Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
                        pq.offer(new int[] { dist, i, j });
                  }
            }
      }
      private int[] assignFromHeap() {

            int[] wo = new int[w];

            boolean[] bikeAssigned = new boolean[w];
            boolean[] workerAssigned = new boolean[w];

            int assigned = 0;
            while (!pq.isEmpty() && assigned < w) {
                  int[] entry = pq.poll();
                  if (!workerAssigned[entry[1]] && !bikeAssigned[entry[2]]) {
                        wo[entry[1]] = entry[2];

                        workerAssigned[entry[1]] = true;
                        bikeAssigned[entry[2]] = true;
                        assigned++;
                  }
            }

            return wo;
      }

      public static void main(String[] args) {

      }
}