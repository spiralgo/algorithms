package algorithms.curated170.easy;

public class FixedPoint {
 
   public int fixedPoint(int[] A) {
        int l = 0, r = A.length - 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (A[m] - m < 0)
                l = m + 1;
            else
                r = m;
        }
        return A[l] == l ? l : -1;
    }
}    
 
