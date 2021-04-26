package algorithms.curated170.medium;

import java.util.Arrays;

class RangeAddition {
    public static int[] solution(int length, int[][] updates) {
        int[] arr = new int[length];
        for (int[] ops : updates) {
            arr[ops[0]] += ops[2];
            if (ops[1]+1 < length) {
                arr[ops[1]+1] -= ops[2];
            }
        }
        for (int i = 1; i < length; i++) {
            arr[i] += arr[i - 1];
        }
        return arr;
    }

    public static void main(String[] args) {
        int[][] updates = { { 1, 3, 2 }, { 2, 4, 3 }, { 0, 2, -2 } };
        System.out.println(Arrays.toString(solution(5, updates))); //prints [-2, 0, 3, 5, 3]
    }
}