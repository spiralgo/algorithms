package algorithms;

import java.util.Arrays;

public class Playground {

    public static void main(String[] args) {
        int[][] in = {{1, 2},
        {0, 2}};

        int low = in.length - 1;
        int high = in.length-1;

        while (high > 0) {
            while (high > low && in[low][0]>0) {                
                low--;
            }
                
           while (in[high][0]>0) {                
                high--;
            }
            in[low][0] = in[high][0];
            in[high][0] = 0;
        }
        printArray(in);
    }

    static void printArray(int[][] in) {
        for (int i = 0; i < in.length; i++) {
            System.out.println(Arrays.toString(in[i]));
            System.out.println();
        }
    }

}
