package algorithms.curated170.medium;

public class SortTransformedArray {

    public class Solution {

        public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
            int n = nums.length, start = 0, end = n - 1;
            int[] res = new int[n];
            
            if (a > 0) {
                for (int i = n - 1; i >= 0; i--) {
                    int y1 = quadratic(nums[start], a, b, c);
                    int y2 = quadratic(nums[end], a, b, c);
                    if (y1 > y2) {
                        res[i] = y1;
                        start++;
                    } else {
                        res[i] = y2;
                        end--;
                    }
                }
            } else {
                for (int i = 0; i < n; i++) {
                    int y1 = quadratic(nums[start], a, b, c);
                    int y2 = quadratic(nums[end], a, b, c);
                    if (y1 < y2) {
                        res[i] = y1;
                        start++;
                    } else {
                        res[i] = y2;
                        end--;
                    }
                }
            }

            return res;
        }

        int quadratic(int x, int a, int b, int c) {
            return a * x * x + b * x + c;
        }
    }

}
