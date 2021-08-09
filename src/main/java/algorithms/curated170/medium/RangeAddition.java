package algorithms.curated170.medium;

import java.util.Arrays;

class RangeAddition {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] arr = new int[length];

        setUpdatesBounds(length, updates, arr);

        applyUpdateValues(length, arr);
        return arr;
    }

    private static void applyUpdateValues(int length, int[] arr) {
        for (int i = 1; i < length; i++) {
            arr[i] += arr[i - 1];
        }
    }

    private static void setUpdatesBounds(int length, int[][] updates, int[] arr) {
        for (int[] query : updates) {
            int start = query[0];
            int end = query[1];
            int val = query[2];

            arr[start] += val;
            if (end + 1 < length) {
                arr[end + 1] -= val;
            }
        }
    }

    public static void main(String[] args) {
        var solution = new RangeAddition();
        int[][] updates = { { 1, 3, 2 }, { 2, 4, 3 }, { 0, 2, -2 } };
        System.out.println(Arrays.toString(solution.getModifiedArray(5, updates))); // prints [-2, 0, 3, 5, 3]
    }
}