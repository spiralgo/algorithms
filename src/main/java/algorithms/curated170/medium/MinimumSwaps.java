package algorithms.curated170.medium;

public class MinimumSwaps {

      public int minSwaps(int[] data) {
            int windowSize = 0;

            for (int i : data) {
                  windowSize += i;
            }

            int minChanges = 0;
            for (int i = 0; i < windowSize; i++) {

                  minChanges += (1 - data[i]);

            }

            int prev = minChanges;

            for (int i = windowSize; i < data.length; i++) {

                  prev += data[i - windowSize] - data[i];

                  minChanges = Math.min(minChanges, prev);
            }
            return minChanges;
      }

      public static void main(String[] args) {

            var solution = new MinimumSwaps();
            System.out.println(solution.minSwaps(new int[] { 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 0, 0,
                        1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1 }));
      }
}