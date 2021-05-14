package algorithms.medium;

public class SingleNumber2 {

    public int singleNumber(int[] nums) {

        int x1 = 0, x2 = 0;

        for (int num : nums) {

            x1 = (x1 ^ num) & ~x2;
            x2 = (x2 ^ num) & ~x1;
        }
        return x1;
    }

    public int singleNumber4(int[] nums) {

        int x1 = 0, x2 = 0, x3 = 0;

        for (int num : nums) {

            x1 = (x1 ^ num) & ~x2 & ~x3;
            x2 = (x2 ^ num) & ~x1 & ~x3;
            x3 = (x3 ^ num) & ~x1 & ~x2;
        }
        return x1;
    }

    public int singleNumber5(int[] nums) {

        int x1 = 0, x2 = 0, x3 = 0, x4 = 0;

        for (int num : nums) {

            x1 = (x1 ^ num) & ~x2 & ~x3 & ~x4;
            x2 = (x2 ^ num) & ~x1 & ~x3 & ~x4;
            x3 = (x3 ^ num) & ~x1 & ~x2 & ~x4;
            x4 = (x4 ^ num) & ~x1 & ~x2 & ~x3;
        }
        return x1;
    }

    public int singleNumber6(int[] nums) {

        int x1 = 0, x2 = 0, x3 = 0, x4 = 0, x5 = 0;

        for (int num : nums) {

            x1 = (x1 ^ num) & ~x2 & ~x3 & ~x4 & ~x5;
            x2 = (x2 ^ num) & ~x1 & ~x3 & ~x4 & ~x5;
            x3 = (x3 ^ num) & ~x1 & ~x2 & ~x4 & ~x5;
            x4 = (x4 ^ num) & ~x1 & ~x2 & ~x3 & ~x5;
            x5 = (x5 ^ num) & ~x1 & ~x2 & ~x3 & ~x4;
        }
        return x1;
    }

    public int singleNumberGeneral(int[] nums, int k) {
        // Couldn't manage this, doesn't work
        int[] sets = new int[k];

        for (int num : nums) {

            for (int i = 0; i < k; i++) {
                int x = sets[i] ^ num;
                for (int j = 0; j < k; j++) {
                    if (j != i) {
                        x &= ~sets[j];
                    }
                }
                sets[i] = x;
            }
        }
        return sets[0];
    }

    
    public static void main(String[] args) {

        var solution = new SingleNumber2();

        int[] nums_0 = new int[] { 2, 2, 5, 7, 7, 5, 9, 2, 5, 7 };
        int[] nums_1 = new int[] { 3, 3, 6, 0, 6, 6, 3 };

        System.out.println(solution.singleNumber(nums_0)); // prints 9
        System.out.println(solution.singleNumber(nums_1)); // prints 0

        int[] nums4 = { 4, 2, 4, 4, 18, 2, 2, 4, 2 };
        System.out.println(solution.singleNumber4(nums4)); // prints 8

        int[] nums5 = { 4, 2, 4, 4, 4, 2, 2, 4, 2, 18, 2 };
        System.out.println(solution.singleNumber5(nums5)); // prints 18

        int[] nums6 = { 2, 4, 2, 4, 4, 4, 2, 2, 4, 2, 180, 2, 4 };
        System.out.println(solution.singleNumber6(nums6)); // prints 180
    }
}