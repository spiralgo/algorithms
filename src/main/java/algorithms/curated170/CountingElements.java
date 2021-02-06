package algorithms.curated170;

import java.util.Arrays;

 
public class CountingElements {
    public int countElements(int[] arr) {
    Arrays.sort(arr);
    int count = 0;
    int runLength = 1;
    for (int i = 1; i < arr.length; i++) {
        if (arr[i - 1] != arr[i]) {
            if (arr[i - 1] + 1 == arr[i]) {
                count += runLength;
            }
            runLength = 0;
        }
        runLength++;
    }
    return count;
}
}
