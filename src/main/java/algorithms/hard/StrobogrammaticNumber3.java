package algorithms.hard;

public class StrobogrammaticNumber3 {

    final char[][] reflectives = new char[][]{
        {'0', '0'},
        {'6', '9'},
        {'1', '1'},
        {'9', '6'},
        {'8', '8'}
    };

    public int strobogrammaticInRange(String low, String high) {

        if (low == null || high == null || low.length() > high.length()
                || (low.length() == high.length() && low.compareTo(high) > 0)) {
            return 0;
        }

        int count = 0;
        for (int len = low.length(); len <= high.length(); len++) {
            count += createNum(low, high, new char[len], 0, len - 1);
        }
        return count;

    }

    int createNum(String low, String high, char[] numBuilder, int left, int right) {
        if (left > right) {

            String s = new String(numBuilder);
            if ((numBuilder.length == low.length() && s.compareTo(low) < 0)
                    || (numBuilder.length == high.length() && s.compareTo(high) > 0)) {
                return 0;
            } else {
                return 1;
            }
        }

        int count = 0;

        for (char[] pair : reflectives) {
            char ch = pair[0];
            numBuilder[left] = ch;
            numBuilder[right] = pair[1];
            if (numBuilder.length != 1 && numBuilder[0] == '0') {
                continue;
            } else if (left == right && (ch == '6' || ch == '9')) {
                continue;
            }
            count += createNum(low, high, numBuilder, left + 1, right - 1);
        }

        return count;

    }
}
