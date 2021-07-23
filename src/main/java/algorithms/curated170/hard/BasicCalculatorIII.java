package algorithms.curated170.hard;

public class BasicCalculatorIII {

    private int i = 0;

    public int calculate(String s) {
        int n = s.length();
        int num = 0;
        int preSum = 0;
        int totalSum = 0;
        char op = '+';

        for (; i < n; i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c))
                num = 10 * num + (c - '0');
            else if (c == '(') {
                i++;
                num = calculate(s);
            }

            if (c == '+' || c == '-' || c == '*' || c == '/' || c == ')' || i == n - 1) {

                if (op == '+')
                    preSum += num;
                else if (op == '-')
                    preSum -= num;
                else if (op == '*')
                    preSum *= num;
                else if (op == '/')
                    preSum /= num;

                if (c == '+' || c == '-' || c == ')' || i == n - 1) {
                    totalSum += preSum;
                    preSum = 0;

                    if (c == ')') {
                        break;
                    }
                }

                num = 0;
                op = c;
            }
        }

        return totalSum;
    }

}
