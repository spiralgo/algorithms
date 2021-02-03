package algorithms.sorting;

// Java program for implementation of Insertion Sort 

import java.util.Arrays;

class InsertionSort { 
	/*Function to sort array using insertion sort*/
	void sort(int arr[]) 
	{ 
		int n = arr.length; 
		for (int i = 1; i < n; ++i) { 
			int key = arr[i]; 
			int j = i - 1; 

			/* Move elements of arr[0..i-1], that are 
			greater than key, to one position ahead 
			of their current position */
			while (j >= 0 && key < arr[j]) { 
				arr[j + 1] = arr[j]; 
				j = j - 1; 
			} 
			arr[j + 1] = key; 
		} 
	} 

 

	// Driver method 
	public static void main(String args[]) 
	{ 
		int arr[] = { 12, 11, 13, 5, 6 }; 

		InsertionSort ob = new InsertionSort(); 
		ob.sort(arr); 
                
                System.out.println(Arrays.toString(arr));
		 
	} 
}  