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
            int minChanges = windowSize;
            for(int i = 0; i<data.length-windowSize; i++)
            {
                  minChanges = Math.min(minChanges, countZeros(i));
            }
            return minChanges;
      }

      private int countZeros(int index)
      {
            int count = 0;
            for(int i = index; i<index+windowSize; i++)
            {
                  if(data[i] == 0)
                  {
                        count++;
                  }
            }
            return count;
      }

      public static void main(String[] args) {

      }
}