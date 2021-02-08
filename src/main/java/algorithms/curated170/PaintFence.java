package algorithms.curated170;

 
public class PaintFence {
 public int numWays(int n, int k) {
        if (n == 0) {
            return 0;
        }
        int same = 0;
        int diff = k;
        for (int i = 2; i <= n; i++) {
            int tmp = same;
            same = diff;
            diff = (tmp + diff) * (k - 1);
        }
        return same + diff;
    }
}