package algorithms.curated170.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

 
public class SortTransformedArrayNaive {
    public static void main(String[] args) {
        SortTransformedArrayNaive sortTransformedArray = new SortTransformedArrayNaive();
         
        int a = 1, b = 3, c = 5;
        int[] output = sortTransformedArray.sortTransformedArray(new int[]{-4,-2,2,4}, a, b, c);
        System.out.println(Arrays.toString(output));
       //Output: [3,9,15,33]
    }
  
  public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int x : nums){
             pq.offer(quadratic(x, a, b, c));
        }
        int i = 0;
        while(!pq.isEmpty()){
             nums[i++] = pq.poll();
        }
        return nums;
 }
 int quadratic(int x, int a, int b, int c){
      return a * x * x + b * x + c;
 }
}
