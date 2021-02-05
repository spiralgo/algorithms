package algorithms.curated170;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class HighFive {

    private int K;

    public int[][] highFive(int[][] items) {
        this.K = 5;
        Arrays.sort(
                items,
                new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) // item with lower id goes first
                {
                    return a[0] - b[0];
                }
                // in case of tie for ids, item with higher score goes first
                return b[1] - a[1];
            }
        });
        List<int[]> solution = new ArrayList<>();
        int n = items.length;
        int i = 0;
        while (i < n) {
            int id = items[i][0];
            int sum = 0;
            // obtain total using the top 5 scores
            for (int k = i; k < i + this.K; ++k) {
                sum += items[k][1];
            }
            // ignore all the other scores for the same id
            while (i < n && items[i][0] == id) {
                i++;
            }
            solution.add(new int[]{id, sum / this.K});
        }
        int[][] solutionArray = new int[solution.size()][];
        return solution.toArray(solutionArray);
    }

    public static void main(String[] args) {
        HighFive hf = new HighFive();

        int[][] items = new int[][]{
         new int[]{1, 91}, new int[]{1, 92}, new int[]{2, 93},
         new int[]{2, 97}, new int[]{1, 60}, new int[]{2, 77}, 
         new int[]{1, 65}, new int[]{1, 87}, new int[]{1, 100}, 
         new int[]{2, 100}, new int[]{2, 76}
                };
        
     int[][] result =  hf.highFive(items);
     
    
    }
}
