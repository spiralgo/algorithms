package algorithms.curated170.medium;

public class PathWithMaximumMinimumValue {

    public static void main(String[] args) {
        PathWithMaximumMinimumValue pathWithMaximumMinimumValue = new PathWithMaximumMinimumValue();

        int[][] A = {{5, 4, 5},
        {1, 2, 6},
        {7, 4, 6}};

        int result = pathWithMaximumMinimumValue.maximumMinimumPath(A);
        System.out.println(result);
    }

    final static int DIRECTIONS[] = {0, 1, 0, -1, 0};

    private int rowCount, colCount;
    private boolean[][] visited;
    private int[][] grid;

    public int maximumMinimumPath(int[][] A) {
        grid = A;
        rowCount = A.length;
        colCount = A[0].length;

        int low = 1, high = Math.min(A[0][0], A[rowCount - 1][colCount - 1]) + 1;

        while (low < high) {
            int mid = (low + high) / 2;
            visited = new boolean[rowCount][colCount];
            if (isThereAPossiblePath(0, 0, mid)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low - 1;
    }

    boolean isThereAPossiblePath(int x, int y, int limit) {
        if (x == rowCount - 1 && y == colCount - 1) {
            return true;
        }
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int dx = x + DIRECTIONS[i];
            int dy = y + DIRECTIONS[i + 1];
            if (dx >= 0 && dy >= 0 && dx <= rowCount - 1 && dy <= colCount - 1 && grid[dx][dy] >= limit && !visited[dx][dy]) {
                if (isThereAPossiblePath(dx, dy, limit)) {
                    return true;
                }
            }

        }
        return false;

    }
}
