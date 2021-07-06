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
  }
}