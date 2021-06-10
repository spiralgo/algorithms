package algorithms.curated170.hard;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class MinimizeMaxDistanceToGasStation {

    public double solve(int[] stats, int k) {
        double left = 0, right = stats[stats.length - 1];
        
        while (left + 1e-6 < right) {
            double mid = (left + right) / 2;
            int count = 0;

            for (int i = 0; i < stats.length - 1; i++) {
                count += (int) ((stats[i + 1] - stats[i]) / mid);
            }

            if (count > k) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        var solution = new MinimizeMaxDistanceToGasStation();

        System.out.println(solution.solve(new int[] { 1, 2, 3, 4, 5 }, 4));
    }
}
