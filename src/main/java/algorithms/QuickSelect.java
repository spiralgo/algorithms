package algorithms;

import java.util.Arrays;

class Quickselect {

  int partition(int[] arr, int left, int right, int pivot) {
    int pivotVal = arr[pivot];

    {
      int temp = arr[right];
      arr[right] = arr[pivot];
      arr[pivot] = temp;
    }

    int storeIndex = left;
    for (int i = left; i < right; i++) {
      if (arr[i] < pivotVal) {
        int temp = arr[storeIndex];
        arr[storeIndex] = arr[i];
        arr[i] = temp;
        storeIndex++;
      }
    }

    int temp = arr[right];
    arr[right] = arr[storeIndex];
    arr[storeIndex] = temp;
    
    return storeIndex;
  }

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

  public static void main(String[] args) {
    int[] arr = { 5, 3, 1, 2, 4 };
    var qs = new Quickselect();
    System.out.println(qs.select(arr, 0, arr.length - 1, 2)); // 3
    System.out.println(Arrays.toString(arr)); // the array is also partially or totally sorted
  }
}