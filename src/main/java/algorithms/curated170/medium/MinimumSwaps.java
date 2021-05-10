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
            int minChanges = countFirstZeros();
            int prev = minChanges;
            for(int i = 1; i<=data.length-windowSize; i++)
            {
                  if(data[i] == 1 && data[i-1] == 0)
                  {
                        prev--;
                  }
                  else if(data[i] == 0 && data[i-1] == 1)
                  {
                        prev++;
                  }
                  if(data[i+windowSize-1] == 1 && data[i+windowSize-2] == 0)
                  {
                        prev--;
                  }
                  else if(data[i+windowSize-1] == 0 && data[i+windowSize-2] == 1)
                  {
                        prev++;
                  }
                  minChanges = Math.min(minChanges, prev);
            }
            return minChanges;
      }

      private int countFirstZeros()
      {
            int count = 0;
            for(int i = 0; i<windowSize; i++)
            {
                  if(data[i] == 0)
                  {
                        count++;
                  }
            }
            return count;
      }

      public static void main(String[] args) {

            var solution = new MinimumSwaps();
            System.out.println(solution.minimumSwaps(new int[] {1,0,0,0,1,0,0,0,1,0,0,0,0,0,0,1}));
      }
}