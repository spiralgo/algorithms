package algorithms.medium.rangesumquerymutable;

public class RangeSumQueryMutableBinaryIndexedTree {

    class NumArray {

        int[] bit;
        int[] nums;

        public NumArray(int[] nums) {
            bit = nums.clone();
            this.nums = nums;
            buildTree();
        }

        private void buildTree() {
            for (int i = 0; i < bit.length; i++) {
                int j = i + lsb(i + 1);
                if (j < bit.length) {
                    bit[j] += bit[i];
                }
            }
        }

        private int lsb(int index) {
            return index & -index;
        }

        public void update(int index, int val) {
            add(index, val - nums[index]);
            nums[index] = val;
        }

        private void add(int index, int val) {
            while (index < bit.length) {
                bit[index] += val;
                index += lsb(index + 1);
            }
        }

        private int prefixSum(int index) {
            int prefixSum = 0;
            while (index >= 0) {
                prefixSum += bit[index];
                index -= lsb(index + 1);
            }
            return prefixSum;
        }

        public int sumRange(int left, int right) {
            return prefixSum(right) - prefixSum(left - 1);
        }

    }

}
