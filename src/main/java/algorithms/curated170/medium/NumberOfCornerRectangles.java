package algorithms.curated170.medium;

 
public class NumberOfCornerRectangles {

    public static void main(String[] args) {
        NumberOfCornerRectangles nocr = new NumberOfCornerRectangles();
        int[][] grid = {{1, 0, 0, 1, 0},
                        {0, 0, 1, 0, 1},
                        {0, 0, 0, 1, 0},
                        {1, 0, 1, 0, 1}};
        
        nocr.countCornerRectangles(grid);
    }
    
   public int countCornerRectangles(int[][] grid) {
        int totalCount = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] counts = new int[rows][cols];
        for (int[] row : grid) {
            for (int col1 = 0; col1 < cols - 1; col1++) {
                if (row[col1] == 1) {
                    for (int col2 = col1 + 1; col2 < cols; col2++) {
                        if (row[col2] == 1) {
                            int count = counts[col1][col2];
                            totalCount += count;
                            counts[col1][col2]++;
                        }
                    }
                }
            }
        }
        return totalCount;
    }
}
