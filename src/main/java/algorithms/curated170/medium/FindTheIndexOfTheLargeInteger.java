package algorithms.curated170.medium;

public class FindTheIndexOfTheLargeInteger {

    public int getIndex(ArrayReader arr) {
        int length = arr.length();
        int l = 0, y = length;
        while (l < y) {
            int range = y - l + 1;
            int mid = (range - 1) / 2 + l;
            int r = l + (range / 2) - 1, x = y - (range / 2) + 1;
            int c = arr.compareSub(l, r, x, y);
            if (c == 0) {
                return mid;
            } else if (c < 0) {
                l = x;
            } else {
                y = r;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        
    }

    public interface ArrayReader {
        public int compareSub(int l, int r, int x, int y);

        public int length();
    }
}