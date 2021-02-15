package algorithms.curated170.medium.medium;

import java.util.Arrays;

 
public class CandyCrush {
    public static void main(String[] args) {
        int[][] board = {
            {1, 1, 1, 2},
            {1, 2, 2, 2},
            {1, 1, 1, 9},
            {1, 1, 1, 9}
        };
        
        int[][] boardCopy = new int[board[0].length][board.length];
    
        for (int i = 0; i < board.length; i++) {
                int low = 0;
                int high = 0;
        
            while(high < board[i].length-1){
                    
             
                if(board[i][high] != board[i][high++]){
                   
                    if(high-low + 1 >= 3){
                        while (low==high) {
                           
                             low++;
                        }
                    }
                   
                   boardCopy[i][low] = board[i][low];
                } 
             
                
            }
    
        }
        System.err.println(Arrays.deepToString(boardCopy));
    }
}
