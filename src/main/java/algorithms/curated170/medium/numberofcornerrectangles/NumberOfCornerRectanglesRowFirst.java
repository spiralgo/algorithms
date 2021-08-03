package algorithms.curated170.medium.numberofcornerrectangles;

public class NumberOfCornerRectanglesRowFirst {

    public int countCornerRectangles(int[][] grid) {
        int totalCount = 0;
        int[][] counts = new int[grid.length][grid.length];
        
        for (int j = 0; j < grid[0].length; j++) {
            for (int i = 0; i < grid.length; i++) {
                if (grid[i][j] == 1) {
                    totalCount += checkNextRowsOfColumn(grid, counts, j, i);
                }

            }
        }
        return totalCount;
    }

    private int checkNextRowsOfColumn(int[][] grid, int[][] counts, int j, int i) {
        int newRechtangles = 0;

        for (int k = i + 1; k < grid.length; k++) {
            if (grid[k][j] == 1) {
                int count = counts[i][k];
                newRechtangles += count;
                counts[i][k]++;
            }
        }

        return newRechtangles;
    }

    public static void main(String[] args) {
        NumberOfCornerRectanglesRowFirst nocr = new NumberOfCornerRectanglesRowFirst();
        int[][] grid = { { 1, 0, 0, 1, 0 }, { 0, 0, 1, 0, 1 }, { 0, 0, 0, 1, 0 }, { 1, 0, 1, 0, 1 } };

        nocr.countCornerRectangles(grid);
    }
}
