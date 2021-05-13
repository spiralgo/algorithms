package algorithms.curated170.medium;

import java.util.Arrays;
import java.util.Random;

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

            if (countRow[row][player]++ == length)
                return player;

            if (countCol[col][player]++ == length)
                return player;

            if (row == col) {

                if (countDia1[player] == length)
                    return player;
            }

            if (row + col == length - 1) {
                if (countDia2[player] == length)
                    return player;
            }

            return 0; // No one wins
        }
    }

    public static void main(String[] args) {

    }
}
