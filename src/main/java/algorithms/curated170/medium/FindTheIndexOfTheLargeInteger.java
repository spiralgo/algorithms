package algorithms.curated170.medium;

public class FindTheIndexOfTheLargeInteger {

    public int getIndex(ArrayReader arr) {
        int length = arr.length();
        int left = 0, right = length - 1;

        while (left < right) {

            int half = (right - left + 1) / 2;

            int c = arr.compareSub(left, left + half - 1, right - half + 1, right);

            if (c == 0) {
                return (right - left) / 2 + left;
            } else if (c < 0) {
                left = right - half + 1;
            } else {
                right = left + half - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {

    }

    public interface ArrayReader {
        public int compareSub(int l, int r, int x, int y);

        public int length();
    }
}
