package algorithms.curated170.medium;

public class SortTransformedArray {

        int n, start = 0, end;
        int[] res;
        int[] nums;
        int a, b, c;

        public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
            n = nums.length;
            res = new int[n];
            end = n-1;
            this.nums = nums;
            this.a = a;
            this.b = b;
            this.c = c;
            
            if (a > 0) {
                for (int i = n - 1; i >= 0; i--) {
                    quadraticComparator(i, true);
                }
            } else {
                for (int i = 0; i < n; i++) {
                    quadraticComparator(i, false);
                }
            }

            return res;
        }

        void quadraticComparator(int i, boolean pbType) {
            int y1 = quadratic(nums[start]);
            int y2 = quadratic(nums[end]);
            if ((pbType && y1 > y2) || (!pbType && y1 < y2)) {
                res[i] = y1;
                start++;
            } else {
                res[i] = y2;
                end--;
            }
        }

        int quadratic(int x) {
            return a * x * x + b * x + c;
        }
}
