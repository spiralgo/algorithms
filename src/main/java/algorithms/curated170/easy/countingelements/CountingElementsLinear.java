package algorithms.curated170.easy.coutingelements;

public class CountingElementsLinear {
    public int countElements(int[] arr) {
        boolean[] check = new boolean[1002];
        int count = 0;
        for (int n : arr) {
            check[n] = true;
        }
        for (int n : arr) {
            if (check[n + 1]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        var solution0 = new CountingElementsLinear();
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
