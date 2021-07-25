package algorithms.curated170.hard;

import java.util.Arrays;

public class DesignExcelSumFormula {

    class Excel {
        Object[][] matrix;
        int m, n;

        public Excel(int height, char width) {
            this.m = height;
            this.n = width - 'A';

            matrix = new Object[m][n + 1];

            for (int i = 0; i < m; i++) {
                Arrays.fill(matrix[i], 0);
            }
        }

        public void set(int row, char column, int val) {
            matrix[row - 1][column - 'A'] = val;
        }

        public int get(int row, char column) {
            if (matrix[row - 1][column - 'A'] instanceof Integer) {
                return (int) matrix[row - 1][column - 'A'];
            } else {
                return calculate(row, column);
            }
        }

        public int sum(int row, char column, String[] numbers) {
            matrix[row - 1][column - 'A'] = numbers;
            return calculate(row, column);
        }

        public int calculate(int row, char column) {
            String[] numbers = (String[]) matrix[row - 1][column - 'A'];

            int sum = 0;
            for (String num : numbers) {
                if (num.indexOf(":") < 0) {
                    char c = num.charAt(0);
                    int r = Integer.parseInt(num.substring(1));

                    sum += get(r, c);
                } else {
                    String num1 = num.substring(0, num.indexOf(":"));
                    String num2 = num.substring(num.indexOf(":") + 1);

                    char c1 = num1.charAt(0);
                    int r1 = Integer.parseInt(num1.substring(1));

                    char c2 = num2.charAt(0);
                    int r2 = Integer.parseInt(num2.substring(1));

                    for (int i = r1; i <= r2; i++) {
                        for (char j = c1; j <= c2; j++) {
                            sum += get(i, j);
                        }
                    }
                }
            }

            return sum;
        }
    }

}
