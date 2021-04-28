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

    public int maximumMinimumPath(int[][] A) {
        int rowCount = A.length, colCount = A[0].length;

        int low = 1, high = Math.min(A[0][0], A[rowCount - 1][colCount - 1]) + 1;
      
        while (low < high) {
            int mid = (low + high) / 2;
            boolean[][] visited = new boolean[rowCount][colCount];
            if (isThereAPossiblePath(A, 0, 0, A.length, A[0].length, mid, visited)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low - 1;
    }

    boolean isThereAPossiblePath(int[][] A, int x, int y, int rowCount, int colCount, int limit, boolean[][] visited) {
        if (x == rowCount - 1 && y == colCount - 1) {
            return true;
        }
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int dx = x + DIRECTIONS[i];
            int dy = y + DIRECTIONS[i + 1];
            if (dx >= 0 && dy >= 0 && dx <= rowCount - 1 && dy <= colCount - 1 && A[dx][dy] >= limit && !visited[dx][dy]) {
                if (isThereAPossiblePath(A, dx, dy, rowCount, colCount, limit, visited)) {
                    return true;
                }
            }

        }
        return false;

    }
}
