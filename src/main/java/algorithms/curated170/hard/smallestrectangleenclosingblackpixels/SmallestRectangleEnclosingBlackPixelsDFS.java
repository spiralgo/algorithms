package algorithms.curated170.hard.employeefreetime;

public class SmallestRectangleEnclosingBlackPixelsDFS {
    
    int left, right, bottom, top;
    int[][] directions = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public int minArea(char[][] image, int x, int y) {
        left = 1000000;
        right = 0;
        bottom = 1000000;
        top = 0;
        findRectangleBoundaries(image, x, y);
        return (right - left + 1) * (top - bottom + 1);
    }

    private void findRectangleBoundaries(char[][] image, int x, int y) {
        if (isOutOfBoundariesOrZero(image, x, y)) {
            return;
        }

        image[x][y] = '0';

        for (int[] dir : directions) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            findRectangleBoundaries(image, nx, ny);
        }
        if (x < left) {
            left = x;
        }
        if (y < bottom) {
            bottom = y;
        }
        if (y > top) {
            top = y;
        }
        if (x > right) {
            right = x;
        }
    }

    private boolean isOutOfBoundariesOrZero(char[][] image, int x, int y) {
        return (x < 0 || y < 0 || x >= image.length || y >= image[0].length || image[x][y] == '0');
    }
}