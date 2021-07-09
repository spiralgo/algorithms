package algorithms.curated170.hard;

public class DivideChocolate {
    
    public int maximizeSweetness(int[] sweetness, int k) {
        k++;
        int sweetMin = 1, sweetMax = (int) 1e5 * sweetness.length / k;

        while (sweetMin < sweetMax) {
            int mid = sweetMin + (sweetMax - sweetMin + 1) / 2;
            int splits = numberOfSplitWithMaxSweetness(sweetness, mid);
            if (splits <= k) {
                sweetMax = mid - 1;
            } else {
                sweetMin = mid;
            }
        }
        return sweetMin;
    }

    private int numberOfSplitWithMaxSweetness(int[] sweetness, int maxSweetness) {
        int splits = 1, currSweetness = 0;
        for (int sweet : sweetness) {
            if ((currSweetness += sweet) >= maxSweetness) {
                currSweetness = 0;
                splits++;
            }
        }
        return splits;
    }
}
