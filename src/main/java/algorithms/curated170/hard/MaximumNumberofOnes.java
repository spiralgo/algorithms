package algorithms.curated170.hard;

import java.util.Arrays;

 
public class MaximumNumberofOnes {
    int width, height, sideLength, maxOnes;
    public int maximumNumberOfOnes(int width, int height, int sideLength, int maxOnes) {
        int squareSize = sideLength*sideLength; 
        int[] square = new int[squareSize];
    
        if (maxOnes >= squareSize) return width * height;
        
        this.width = width;
        this.height = height;
        this.sideLength = sideLength;
        this.maxOnes = maxOnes;
      
         for(int i = 0; i<sideLength; i++){
         for(int j = 0; j<sideLength; j++){
             square[getTileId(i, j)] =  getTileCount(i,j);
           }
         }
 
        Arrays.sort(square);
        int output = 0;
        for (int i = square.length-1, j = 0; j < maxOnes; i--, j++) {
            output += square[i]; 
        }
        return output;
    }
     int getTileId(int i, int j) {
        return sideLength * i + j;
     }
     int getTileCount(int i, int j){
        return ((height - (i+1))/sideLength+1) * ((width - (j+1))/sideLength+1);
     }
}
