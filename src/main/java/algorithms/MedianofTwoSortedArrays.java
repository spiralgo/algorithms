/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

/**
 *
 * @author ASUS
 */
public class MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        double result = 0;

        if (nums1.length > nums2.length) {

            int[] temp = nums2;
            nums2 = nums1;
            nums1 = temp;
        }

        int low = 0;
        int high = nums1.length;
        int totalLength = nums1.length + nums2.length;
        int partitionPoint = (totalLength + 1) / 2;

        while (low <= high) {
            int partitionPointNums1 = (low + high+1) / 2;
            int partitionPointNums2 = partitionPoint - partitionPointNums1;

            int leftNums1Max = (partitionPointNums1!=0) ? nums1[partitionPointNums1-1]
                    : Integer.MIN_VALUE;
            int leftNums2Max =  (partitionPointNums2!=0) ? nums2[partitionPointNums2-1]
                    : Integer.MIN_VALUE;

            int rightNums1Min = (partitionPointNums1!=nums1.length) ? nums1[partitionPointNums1]
                    : Integer.MAX_VALUE;
            int rightNums2Min = (partitionPointNums2!=nums2.length)? nums2[partitionPointNums2]
                    : Integer.MAX_VALUE;

            
            
            
             if (partitionPointNums1  > low && leftNums1Max > rightNums2Min) {
                high = partitionPointNums1 - 1;
            } else if (partitionPointNums1  < high &&  leftNums2Max > rightNums1Min) {
                low = partitionPointNums1 + 1;
            } else {
                
                
                int maxLeft = Math.max(leftNums1Max, leftNums2Max);
                
               if (totalLength % 2 == 0) {
                   int minRight = Math.min(rightNums1Min, rightNums2Min);

                    result = (maxLeft + minRight) / 2.0;
                } else {
                    result = maxLeft;
                }
               break;
            } 
        }

        return result;

    }

     public static void main(String[] args) {
        MedianofTwoSortedArrays medianofTwoSortedArrays = new MedianofTwoSortedArrays();
        
        double result = medianofTwoSortedArrays.findMedianSortedArrays(new int[]{1,2,6}, new int[]{3,4,5});
         System.out.println(result);
     }
}
