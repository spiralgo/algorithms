package algorithms.curated170.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class CampusBikesPriorityQueue {

      int w, b;
      PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                  return a[0] != b[0] ? a[0] - b[0] : (a[1] != b[1] ? a[1] - b[1] : (a[2] - b[2]));
            }
      });

      public int[] assignBikes(int[][] workers, int[][] bikes) {

            w = workers.length;
            b = bikes.length;

            createHeap(workers, bikes);

            return assignFromHeap();
      }

      private void createHeap(int[][] workers, int[][] bikes) {
            for (int i = 0; i < w; i++) {
                  for (int j = 0; j < b; j++) {

                        int dist = dist(workers[i], bikes[j]);
                        pq.offer(new int[] { dist, i, j });
                  }
            }
      }

      private int[] assignFromHeap() {

            int[] wo = new int[w];

            boolean[] bikeAssigned = new boolean[b];
            boolean[] workerAssigned = new boolean[w];

            int assigned = 0;
            while (!pq.isEmpty() && assigned < w) {
                  int[] entry = pq.poll();

                  int w_ = entry[1];
                  int b_ = entry[2];

                  if (!workerAssigned[w_] && !bikeAssigned[b_]) {
                        wo[w_] = b_;

                        workerAssigned[w_] = true;
                        bikeAssigned[b_] = true;
                        assigned++;
                  }
            }

            return wo;
      }

      private int dist(int[] w, int[] b) {
            return Math.abs(w[0] - b[0]) + Math.abs(w[1] - b[1]);
      }

      public static void main(String[] args) {
            int[][] workers0 = {{664,994},{3,425},{599,913},{220,352},{145,348},{604,428},{519,183},{732,148}};

            int[][] bikes0 = {{611,698},{113,338},{579,770},{276,588},{948,679},{731,525},{925,877},{182,281},{39,299}};


            var solution = new CampusBikesPriorityQueue();
            System.out.println(Arrays.toString(solution.assignBikes(workers0, bikes0)));
      }
}