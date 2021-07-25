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
    
          public boolean canFind(int[] sums, int k, double mid) {
        double sum = 0;
        double preSum=0, minPreSum = 0;
        for (int i = k-1; i < sums.length; i++) {
            sum = getSumInRange(i,0, sums, mid);
           
            if (i-k >= 0){
                 preSum = getSumInRange(i,k, sums, mid);
                 minPreSum = Math.min(minPreSum, preSum);
            } 
            if (sum - minPreSum >= 0) return true;
        }
        return false;
    }
    
     double getSumInRange(int i, int k, int[] sums, double mid){
        return sums[i-k] - (i-k+1) * mid;
     }

}
