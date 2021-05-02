package algorithms.curated170.medium;

import java.util.List;

public class LeftmostColumnwithatLeastaOne {

    public static void main(String[] args) {
        LeftmostColumnwithatLeastaOne l = new LeftmostColumnwithatLeastaOne();
        int output = l.leftMostColumnWithOne(new BinaryMatrixImplement());
        System.out.println(output);
    }

    //Row-First solution
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimensions = binaryMatrix.dimensions();
        int m = dimensions.get(0);
        int n = dimensions.get(1);
        int currentResult = n;

        for (int row = 0; row < m; row++) {
            int high = n - 1;
            int low = 0;

            while (low < high) {
                int mid = (low + high) / 2;

                if (binaryMatrix.get(row, mid) == 0) {

                    low = mid + 1;

                } else {

                    high = mid;

                }
            }
            if (binaryMatrix.get(row, low) == 1) {
                currentResult = Math.min(low, currentResult);
            }
        }
        return currentResult == n ? -1 : currentResult;

    }

    //Col-first solution
    public int leftMostColumnWithOneColFirst(BinaryMatrix binaryMatrix) {

        List<Integer> dimensions = binaryMatrix.dimensions();
        int m = dimensions.get(0);
        int n = dimensions.get(1);

        int currentRow = 0;
        int currentCol = n - 1;
        while (currentRow < m && currentCol >= 0) {

            if (binaryMatrix.get(currentRow, currentCol) == 0) {
                currentRow++;

            } else {
                currentCol--;
            }
        }
        return currentCol == n - 1 ? -1 : currentCol + 1;
    }
}
