package algorithms.curated170.medium.candycrush;

 
public class CandyCrushFaster {
class Solution {
    public int[][] candyCrush(int[][] board) {
        int[][] target = new int[board.length][board[0].length];
        while (crush(board, target)) {
            int[][] temp = board;
            board = target;
            target = temp;
        }
        return board;
    }

    private boolean crush(int[][] source, int[][] target) {
        copy(source, target);

        boolean crush = false;
        for (int i = 0; i < source.length; i++) {
            int[] sourceRow = source[i];
            int[] targetRow = target[i];

            for (int j = 0; j < sourceRow.length; j++) {
                if (j < sourceRow.length - 2) {
                    if (sourceRow[j] != 0 && sourceRow[j] == sourceRow[j + 1] && sourceRow[j] == sourceRow[j + 2]) {
                        crush = true;
                        targetRow[j] = 0;
                        targetRow[j + 1] = 0;
                        targetRow[j + 2] = 0;
                    }
                }
                if (i < source.length - 2) {
                    if (sourceRow[j] != 0 && sourceRow[j] == source[i + 1][j] && sourceRow[j] == source[i + 2][j]) {
                        crush = true;
                        targetRow[j] = 0;
                        target[i + 1][j] = 0;
                        target[i + 2][j] = 0;
                    }
                }
            }
        }

if (crush) {
            drop(target);
        }
        return crush;
    }

    private void drop(int[][] target) {
        for (int col = 0; col < target[0].length; col++) {
            int targetIndex = target.length - 1;
            for (int row = target.length - 1; row >= 0; row--) {
                if (target[row][col] != 0) {
                    if (row != targetIndex) {
                        target[targetIndex][col] = target[row][col];
                        target[row][col] = 0;
                    }
                    targetIndex--;
                }
            }
        }
    }

    private void copy(int[][] source, int[][] target) {
        for (int i = 0; i < source.length; i++) {
            System.arraycopy(source[i], 0, target[i], 0, source[i].length);
        }
    }
}
}
