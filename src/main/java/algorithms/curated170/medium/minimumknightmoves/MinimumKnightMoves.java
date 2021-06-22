package algorithms.curated170.medium.minimumknightmoves;

public class MinimumKnightMoves {

    public int minKnightMoves(int x, int y) {

        x = Math.abs(x);
        y = Math.abs(y);

        if (x < y) {
            int temp = x;
            x = y;
            y = temp;
        }
        if (x == 1 && y == 0) {
            return 3;
        }
        if (x == 2 && y == 2) {
            return 4;
        }
        int delta = x - y;
        if (2 * y > x) {
            return (int) (delta - 2 * Math.floor((float) (delta - y) / 3));
        } else {
            return (int) (delta - 2 * Math.floor((float) (delta - y) / 4));
        }
    }

}
