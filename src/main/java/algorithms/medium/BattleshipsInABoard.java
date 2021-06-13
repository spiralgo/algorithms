package algorithms.medium;

public class BattleshipsInABoard {

    private final char BATTLESHIP = 'X';

    public int countBattleships(char[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                if (board[i][j] == BATTLESHIP && !hasBattleshipBefore(i, j, board)
                        && !hasBattleshipBefore(i, j, board)) {
                    count++;
                }

            }
        }
        return count;
    }

     private boolean hasBattleshipBefore(int i, int j, char[][] board) {
            return (j != 0 && board[i][j - 1] == BATTLESHIP) ||   (i != 0 && board[i - 1][j] == BATTLESHIP);
     }
}

}
