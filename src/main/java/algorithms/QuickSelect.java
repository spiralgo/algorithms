package algorithms;

import java.util.Arrays;

class Quickselect {

  int select(int[] arr, int left, int right, int k) {
    if (left == right) {
      return arr[left];
    }
    int pivot = (left + right) / 2;
    pivot = partition(arr, left, right, pivot);
    if (k < pivot) {
      return select(arr, left, pivot - 1, k);
    } else if (k > pivot) {
      return select(arr, pivot + 1, right, k);
    } else {
      return arr[k];
    }
  }

  int partition(int[] arr, int left, int right, int pivot) {
    int pivotVal = arr[pivot];
    swap(arr, pivot, right);

    int storeIndex = left;
    for (int i = left; i < right; i++) {
      if (arr[i] < pivotVal) {
        swap(arr, storeIndex, i);
        storeIndex++;
      }
    }

    swap(arr, storeIndex, right);

    return storeIndex;
  }
  private int selectIterative(int[] nums, int start, int end, int k) {
    // k is 1-indexed
    int left = start, right = end, pivot = nums[(start+end)/2];
    while (left <= right) {
        while (nums[left] < pivot) left++;
        while (nums[right] > pivot) right--;
        if (left >= right) break;
        swap(nums, left++, right--);
    }
    if (left-start >= k) return selectIterative(nums, start, left-1, k);
    else if (left-start+1 == k && left == right) return nums[left];
    else return selectIterative(nums, right+1, end, k-right+start-1);
}
  void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void main(String[] args) {
    int[] arr = { 5, 3, 1, 2, 4 };
    var qs = new Quickselect();
    System.out.println(qs.select(arr, 0, arr.length - 1, 2)); // 3
    System.out.println(Arrays.toString(arr)); // the array is also partially or totally sorted
    arr = new int[]{ 5, 3, 1, 2, 4 };
    System.out.println(qs.selectIterative(arr, 0, arr.length - 1, 3)); // 3
  }
}