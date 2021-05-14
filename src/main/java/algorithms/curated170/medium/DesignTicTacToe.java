package algorithms.curated170.medium;

public class DesignTicTacToe {

    public class TicTacToe {
        int[][] countRow;
        int[][] countCol;
        int[] countDia1;
        int[] countDia2;
        int length;
   
        public TicTacToe(int n) {
            length = n;
            countRow = new int[n][3];
            countCol = new int[n][3];
            countDia1 = new int[3];
            countDia2 = new int[3];
        }
   
        public int move(int row, int col, int player) {
          
         return ((++countRow[row][player] == length) 
             ||  (++countCol[col][player] == length)
             ||  (row == col && ++countDia1[player] == length)
             ||  (row + col + 1 == length &&  ++countDia2[player] == length)
                ) ? player : 0; 
   
        }
    }

    public static void main(String[] args) {

    }
}
