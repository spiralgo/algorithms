package algorithms.curated170.medium.medium;
 
import java.util.Arrays;

public class CandyCrush {

    public static void main(String[] args) {
        int[][] board = {
            {6, 1},
            {1, 2},
            {1, 2},
            {1, 2},
            {6, 2},
            {6, 2},
            {1, 2},
           
        };
        
        candyCrush(board);
   
    }
  
     static boolean  signal = false; 
      
      public static int[][] candyCrush(int[][] board) {
        int[][] boardCopy = marking(board);
        
        System.out.println("DROP:");
        board =  drop(boardCopy);
         
         marking(board);
         
        return signal ? candyCrush(board) : board;

        
         
    }
     
    public static int[][] marking(int[][] board){
        signal = false;
        int[][] boardCopy = new int[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            int low = 0;

            for (int high = 1; high < board[i].length + 1; high++) {

                while (high < board[i].length && board[i][low] != board[i][high] 
                        || low < high && high == board[i].length) {

                    if (board[i][low]!=0 && high - low  >= 3) {
                        
                        signal = true;
                        while (low <high) {
                            boardCopy[i][low] = 0;
                            low++;

                        }
                    } else {
                        while (low <high) {

                            boardCopy[i][low] = board[i][low];
                            low++;

                        }

                    }

                }

            }

        }
        
        
        for (int j = 0; j < board[0].length; j++) {
            int low = 0;

            for (int high = 1; high < board.length + 1; high++) {

                while (high < board.length && board[low][j] != board[high][j] 
                        || low < high && high == board.length) {

                    if (board[low][j]!=0 && high - low  >= 3) {
                        signal = true;
                        while (low <high) {
                            boardCopy[low][j] = 0;
                            low++;

                        }
                    } else {
                        while (low <high) {
                                
                 
                            low++;

                        }

                    }

                }

            }

        }
       return boardCopy;
    }  
  
    
    
    public static int[][] drop( int[][] array) { 

       
        int[][] arrayClone = new int[array.length][array[0].length];

  

        for (int j = 0; j < array[0].length; j++) {
            
            int counter = array.length - 1;
            
            for (int i = array.length - 1; i >= 0; i--) {

                if (array[i][j] != 0) {
                    arrayClone[counter--][j] = array[i][j];

                }
            }
        }
        printArray(arrayClone);
     
        return arrayClone; 
    }


    
    static void printArray(int[][] boardToPrint){
        for (int i = 0; i < boardToPrint.length; i++) {
            System.out.println( Arrays.toString(boardToPrint[i]));
          
        }
    }
}