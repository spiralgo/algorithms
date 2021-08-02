package algorithms.curated170.medium.numberofcornerrectangles;

public class NumberOfCornerRectanglesRowFirst {

    public int countCornerRectangles(int[][] grid) {
        int totalCount = 0;
        for (int i = 0; i < grid.length - 1; i++) {
            for (int j = i + 1; j < grid.length; j++) {
                int count = 0;
                for (int k = 0; k < grid[0].length; k++) {
                    if (grid[i][k] == 1 && grid[j][k] == 1)
                        count++;
                }
                if (count > 0)
                    totalCount += count * (count - 1) / 2;
            }
        }
        return totalCount;
    }

    public static void main(String[] args) {
        NumberOfCornerRectanglesRowFirst nocr = new NumberOfCornerRectanglesRowFirst();
        int[][] grid = { { 1, 0, 0, 1, 0 }, { 0, 0, 1, 0, 1 }, { 0, 0, 0, 1, 0 }, { 1, 0, 1, 0, 1 } };

        nocr.countCornerRectangles(grid);
    }
}
