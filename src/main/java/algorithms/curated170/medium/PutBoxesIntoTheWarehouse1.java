package algorithms.curated170.medium;

import java.util.Arrays;
import java.util.Random;

public class PutBoxesIntoTheWarehouse1 {
    public static int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        //Time complexity: O(n log n ) (because of sorting)
        //Spatial complexity: O(1)
        
        Arrays.sort(boxes);
        int count = 0; //We store our counting here.

        //We will begin by comparing the highest box.
        //We loop through each room in the warehouse.
        /*If the room's height is greater or equal to
         the height of the box at index b, we can place
         the box there. We increment our counter and consider the next room.*/

        //If we place the box, we move on to looking at boxes with lower height.
        //If we do not place the box, we move on by comparing boxes of lower heigth.
        //For the both cases, we decrement the index b.

        for (int b = boxes.length-1; count < warehouse.length && b >= 0; b--) { 
            if (warehouse[count] >= boxes[b]) {count++;}  
        }
        return count;
    }
    
    public static void main(String[] args) {
        
        int[] boxes0 = new int[]{3,2,1,4};
        int[] rooms0 = new int[]{3,3,1,4};
        System.out.println(maxBoxesInWarehouse(boxes0, rooms0)); //prints 3

        int[] boxes1 = new int[12];
        int[] rooms1 = new int[12];
        for(int i = 0; i<12; i++)
        {
            boxes1[i] = new Random().nextInt(20)+1;
            rooms1[i] = new Random().nextInt(20)+1;
        }
        System.out.println(Arrays.toString(boxes1));
        System.out.println(Arrays.toString(rooms1));

        System.out.println(maxBoxesInWarehouse(boxes1, rooms1)); 
    }
}
