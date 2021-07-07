package algorithms.medium.mapofhighestpeak;

public class MapOfHighestPeak {

    public int[][] highestPeak(int[][] arr) {
        int rows = arr.length;
        int cols = arr[0].length;
        int[][] heightMap = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (arr[i][j] != 1) {
                    heightMap[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        compareToLeft(rows, cols, heightMap);
        compareToRight(rows, cols, heightMap);
        compareToDown(rows, cols, heightMap);
        compareToUp(rows, cols, heightMap);

        return heightMap;
    }

    private void compareToLeft(int n, int m, int[][] heightMap) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m - 1; j++) {
                if (heightMap[i][j] != Integer.MAX_VALUE) {
                    heightMap[i][j + 1] = Math.min(heightMap[i][j + 1], heightMap[i][j] + 1);
                }
            }
        }
    }

    private void compareToRight(int n, int m, int[][] heightMap) {
        for (int i = 0; i < n; i++) {
            for (int j = m - 1; j >= 1; j--) {
                if (heightMap[i][j] != Integer.MAX_VALUE) {
                    heightMap[i][j - 1] = Math.min(heightMap[i][j - 1], heightMap[i][j] + 1);
                }
            }
        }
    }

    private void compareToDown(int n, int m, int[][] heightMap) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m; j++) {
                if (heightMap[i][j] != Integer.MAX_VALUE) {
                    heightMap[i + 1][j] = Math.min(heightMap[i + 1][j], heightMap[i][j] + 1);
                }
            }
        }
    }

    private void compareToUp(int n, int m, int[][] heightMap) {
        for (int i = n - 1; i >= 1; i--) {
            for (int j = 0; j < m; j++) {
                if (heightMap[i][j] != Integer.MAX_VALUE) {
                    heightMap[i - 1][j] = Math.min(heightMap[i - 1][j], heightMap[i][j] + 1);
                }
            }
        }
    }

}
