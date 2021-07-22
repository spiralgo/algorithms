package algorithms.curated170.hard;

public class MaximumAverageSubarrayII {

    public double findMaxAverage(int[] nums, int k) {
        if (nums.length == 1 && k != 0) return (double)nums[0];
        
        double lo = 1e-5;
        double hi = 1e5;
        
        
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) sums[i] = sums[i-1] + nums[i];
        
        double delta = 1e-5;
        while (lo + delta < hi) {
            double mid = (lo + hi) / 2;
            if (canFind(sums, k, mid)) lo = mid;
            else hi = mid;
        }
        return lo;
    }
    
    public boolean canFind(int[] sums, int k, double v) {
        double sum = 0;
        double minPreSum = 0;
        for (int i = k-1; i < sums.length; i++) {
            sum = sums[i] - (i+1) * v;
            if (i-k >= 0) minPreSum = Math.min(minPreSum, sums[i-k] - (i-k+1) * v);
            if (sum > minPreSum) return true;
        }
        return false;
    }

}
