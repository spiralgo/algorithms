package algorithms.curated170.hard;

import java.util.Arrays;

public class DesignExcelSumFormula {

    class Excel {
        
        private static final int NO_POS = -1;
        Object[][] matrix;
        private final int M, N;

        public Excel(int height, char width) {
            M = height;
            N = colIdx(width);

            matrix = new Object[M][N + 1];

            for (int i = 0; i < M; i++) {
                Arrays.fill(matrix[i], 0);
            }
        }

        public void set(int row, char col, int val) {
            matrix[row - 1][colIdx(col)] = val;
        }

        public int get(int row, char col) {
            if (matrix[row - 1][colIdx(col)] instanceof Integer) {
                return (int) matrix[row - 1][colIdx(col)];
            } else {
                return calculate(row, col);
            }
        }

        public int sum(int row, char col, String[] numbers) {
            matrix[row - 1][colIdx(col)] = numbers;
            return calculate(row, col);
        }

        public int calculate(int row, char col) {
            String[] numbers = (String[]) matrix[row - 1][colIdx(col)];

            int sum = 0;
            for (String num : numbers) {
                int separatorIdx = num.indexOf(":");

                if (separatorIdx == NO_POS) {
                    char c = num.charAt(0);
                    int r = Integer.parseInt(num.substring(1));

                    sum += get(r, c);
                } else {
                    sum += sumSubMatrix(num, separatorIdx);
                }
            }

            return sum;
        }

        private int sumSubMatrix(String num, int separatorIdx) {
            int sum = 0;
            
            String cell1 = num.substring(0, separatorIdx);
            String cell2 = num.substring(separatorIdx + 1);

            char c1 = cell1.charAt(0);
            int r1 = Integer.parseInt(cell1.substring(1));

            char c2 = cell2.charAt(0);
            int r2 = Integer.parseInt(cell2.substring(1));

            for (int i = r1; i <= r2; i++) {
                for (char j = c1; j <= c2; j++) {
                    sum += get(i, j);
                }
            }
            return sum;
        }

        private int colIdx(char col) {
            return col - 'A';
        }

    }

}
