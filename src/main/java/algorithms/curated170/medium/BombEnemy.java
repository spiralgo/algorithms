package algorithms.curated170.medium;

public class BombEnemy {

    char[][] grid;
    int rows, cols;

    public int maxKilledEnemies(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }

        this.grid = grid;
        rows = grid.length;
        cols = grid[0].length;

        int maxCount = 0, rowHits = 0;
        int[] colHits = new int[cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                if (isStartOrAfterWall(row, col, true)) {
                    rowHits = countRowHits(row, col);
                }

                if (isStartOrAfterWall(row, col, false)) {
                    countColHits(colHits, row, col);
                }

                if (grid[row][col] == '0') {
                    maxCount = Math.max(maxCount, rowHits + colHits[col]);
                }
            }
        }

        return maxCount;
    }

    private boolean isStartOrAfterWall(int row, int col, boolean checkCol) {
        if (checkCol) {
            return col == 0 || grid[row][col - 1] == 'W';
        } else checkRow: {
            return row == 0 || grid[row - 1][col] == 'W';
        }
    }

    private void countColHits(int[] colHits, int row, int col) {
        colHits[col] = 0;
        for (int i = row; i < rows; ++i) {
            if (grid[i][col] == 'W') {
                break;
            } else if (grid[i][col] == 'E') {
                colHits[col]++;
            }
        }
    }

    private int countRowHits(int row, int col) {
        int rowHits;
        rowHits = 0;
        for (int j = col; j < cols; ++j) {
            if (grid[row][j] == 'W') {
                break;
            } else if (grid[row][j] == 'E') {
                rowHits++;
            }
        }
        return rowHits;
    }

    public static void main(String[] args) {

    }
}