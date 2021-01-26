package algorithms.sorting;

import java.util.Arrays;

class SelectionSort 
{ 
    void sort(int arr[]) 
    { 
        int n = arr.length;  
        for (int i = 0; i < n-1; i++) 
        {  
            int currentMinimum = i; 
            for (int j = i+1; j < n; j++){
               
                if (arr[j] < arr[currentMinimum]){
                    currentMinimum = j; 
                }
                    
            }
                
            //Swap  
            int temp = arr[currentMinimum]; 
            arr[currentMinimum] = arr[i]; 
            arr[i] = temp; 
        } 
    } 
 
  
    // Driver code to test above 
    public static void main(String args[]) 
    { 
        SelectionSort ob = new SelectionSort(); 
        int arr[] = {64,25,12,22,11}; 
        ob.sort(arr); 
        System.out.println("Sorted array: " +  Arrays.toString(arr)); 
  
    } 
} 