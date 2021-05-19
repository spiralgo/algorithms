package algorithms.curated170.easy.countingelements;

import java.util.HashSet;
import java.util.Set;

public class CountingElementsSet {
    public int countElements(int[] arr) {

        Set<Integer> nums = new HashSet<>();
        int count = 0;
        for (int n : arr) {
            nums.add(n);
        }
        for (int n : arr) {
            if (nums.contains(n + 1)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        var solution0 = new CountingElementsSet();
        var solution1 = new CountingElements();

        int[] arr = { 1, 2, 3 };
        System.out.println(solution0.countElements(arr));
        System.out.println(solution1.countElements(arr));
        System.out.println("#");

        arr = new int[] { 1, 1, 2, 2 };
        System.out.println(solution0.countElements(arr));
        System.out.println(solution1.countElements(arr));
        System.out.println("#");

        arr = new int[] { 1, 1, 2 };
        System.out.println(solution0.countElements(arr));
        System.out.println(solution1.countElements(arr));
        System.out.println("#");

        arr = new int[] { 1, 1, 3, 3, 5, 5, 7, 7 };
        System.out.println(solution0.countElements(arr));
        System.out.println(solution1.countElements(arr));
        System.out.println("#");

        arr = new int[] { 1, 3, 2, 3, 5, 0 };
        System.out.println(solution0.countElements(arr));
        System.out.println(solution1.countElements(arr));
        System.out.println("#");
    }
}
