package algorithms;

public class MaximumLineLengthWithSumLessThanOrEqualToThreshold {
  
  public int maxLength(int[] array, int threshold) {
    int len = 1;
    int[] sums = new int[array.length + 1];
    for (int i = 1; i <= array.length; i++) {
      sums[i] += sums[i-1] + array[i - 1];
      if (i >= len && sums[i] - sums[i - len] <= threshold) {
        len++;
      }
    }
    return len - 1;
  }

  public static void main(String[] args) {
    int[] array = { 1, 1, 1, 3, 5 };
    // Prefix sum: [0, 1, 2, 3, 6, 11]
    var solution = new MaximumLineLengthWithSumLessThanOrEqualToThreshold();
    System.out.println(solution.maxLength(array, 15)); // 5
    System.out.println(solution.maxLength(array, 3)); // 3
  }
}