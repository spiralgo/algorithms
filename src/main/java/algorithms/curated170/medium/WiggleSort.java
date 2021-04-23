package algorithms.curated170.medium;

import java.util.Arrays;
import java.util.Random;

public class WiggleSort {
    
    //At even indices, we check to switch the numbers if the number here is greater than the next one
    //At odd  indices, we check to switch the numbers if the number here is not greater than the next one
    public static int[] wiggleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) { 
            if ((i % 2 == 0) == (arr[i] > arr[i + 1])) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[20];
        for (int i = 0; i < 20; i++) {
            arr[i] = new Random().nextInt(30);
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(wiggleSort(arr)));
    }

}
