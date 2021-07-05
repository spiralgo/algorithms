package algorithms.medium.mapofhighestpeak;

public class MapOfHighestPeak {

    public int[][] highestPeak(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int[][] heightMap = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] != 1) {
                    heightMap[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        compareToLeft(n, m, heightMap);
        compareToRight(n, m, heightMap);
        compareToDown(n, m, heightMap);
        compareToUp(n, m, heightMap);

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
