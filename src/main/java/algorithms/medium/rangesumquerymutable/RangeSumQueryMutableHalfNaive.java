package algorithms.medium.rangesumquerymutable;

public class RangeSumQueryMutableHalfNaive {

    class NumArray {
        int arr[];
        int totalSum;

        public NumArray(int[] nums) {
            for (int i = 0; i < nums.length; i++)
                totalSum += nums[i];

            arr = nums;
        }

        public void update(int index, int val) {
            totalSum += (val - arr[index]);
            arr[index] = val;
        }

        public int sumRange(int left, int right) {
            if (left == 0 && right + 1 == arr.length) {
                return totalSum;
            }

            if (right - left < (arr.length >> 1)) {
                return countValuesInRange(left, right);
            }

            return excludeValuesOutOfRange(left, right);
        }

        private int excludeValuesOutOfRange(int left, int right) {
            int s = totalSum;
            for (int i = 0; i < left; i++) {
                s -= arr[i];
            }
            for (int i = arr.length - 1; i > right; i--) {
                s -= arr[i];
            }
            return s;
        }

        private int countValuesInRange(int left, int right) {
            int s = 0;
            for (int i = left; i <= right; i++) {
                s += arr[i];
            }
            return s;
        }
    }

}
