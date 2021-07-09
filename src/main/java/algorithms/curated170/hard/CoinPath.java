package algorithms.curated170.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CoinPath {
    public List<Integer> cheapestJump(int[] A, int B) {
        int coins = A.length;
        if (A == null || coins < 1 || A[coins - 1] < 0) {
            return List.of();
        }
        int[] forwardPathData = new int[coins];
        forwardPathData[coins - 1] = -1;

        for (int i = coins - 2; i >= 0; i--) {
            if (A[i] == -1) {
                continue;
            }

            int minCost = Integer.MAX_VALUE;
            int jumpingLimit = Math.min(i + B, coins - 1);

            for (int j = i + 1; j <= jumpingLimit; j++) {
                if (A[j] == -1) {
                    continue;
                }
                if (A[j] < minCost) {
                    minCost = A[j];
                    forwardPathData[i] = j;
                }
            }

            if (minCost != Integer.MAX_VALUE) {
                A[i] += minCost;
            } else {
                A[i] = -1;
            }
        }

        if (A[0] == -1) {
            return List.of();
        }

        List<Integer> path = new ArrayList<>();
        int k = 0;
        while (k != -1) {
            path.add(k + 1);
            k = forwardPathData[k];
        }
        return path;
    }
}
