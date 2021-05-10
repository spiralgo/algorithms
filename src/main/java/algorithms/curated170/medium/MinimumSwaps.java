package algorithms.curated170.medium;

public class MinimumSwaps {
      private int[] data;
      private int windowSize = 0;

      public int minimumSwaps(int[] data) {
            this.data = data;
            for (int i : data) {
                  if (i == 1) {
                        windowSize++;
                  }
            }
            if (windowSize == 0 || windowSize == 1) {
                  return 0;
            }

            int minChanges = 0;
            for (int i = 0; i < windowSize; i++) {
                  if (data[i] == 0) {
                        minChanges++;
                  }
            }

            int prev = minChanges;
            for (int l = 1, r = windowSize; l <= data.length - windowSize; l++, r++) {
                  int a = data[l], b = data[r];
                  if (a == b) {
                        continue;
                  }
                  System.out.println(a + " " + b +  " prev: " + prev + " index: " + l);
                  if (a > b) {
                        prev--;
                  } else if (a < b) {
                        prev++;
                  }
                  minChanges = Math.min(minChanges, prev);
            }
            return minChanges;
      }

      public static void main(String[] args) {

            var solution = new MinimumSwaps();
            System.out.println(solution.minimumSwaps(new int[] { 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1}));
      }
}