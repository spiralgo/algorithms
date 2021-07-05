package algorithms.curated170.hard.smallestrectangleenclosingblackpixels;

public class SmallestRectangleEnclosingBlackPixelsBinarySearch {

    private char[][] image;

    public int minArea(char[][] image, int x, int y) {
        this.image = image;
        int m = image.length, n = image[0].length;

        int bottom = searchBoundary(0, x, 0, n, true, true);
        int top = searchBoundary(x + 1, m, 0, n, false, true);
        int left = searchBoundary(0, y, bottom, top, true, false);
        int right = searchBoundary(y + 1, n, bottom, top, false, false);

        return (right - left) * (top - bottom);
    }

    private int searchBoundary(int i, int j, int low, int high, boolean findMin, boolean isRow) {
        while (i != j) {
            int k = low, mid = (i + j) / 2;
            while (k < high && isBlack(mid, k, isRow)) {
                k++;
            }
            if ((k < high) == findMin) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }

        return i;
    }

    private boolean isBlack(int mid, int k, boolean isRow) {
        return ((isRow) ? image[mid][k] : image[k][mid]) == '0';
    }
}