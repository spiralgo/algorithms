package algorithms.curated170.hard;

public class NumberOfShipsInARectangle {

    public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {
        if (!sea.hasShips(topRight, bottomLeft)) {
            return 0;
        }

        final int X_A = bottomLeft[0], X_B = topRight[0], Y_A = bottomLeft[1], Y_B = topRight[1];

        if (X_A == X_B && Y_A == Y_B) {
            return 1;
        }

        final int MID_X = (X_A + X_B) / 2;
        final int MID_Y = (Y_A + Y_B) / 2;
        return countShips(sea, new int[] { MID_X, MID_Y }, bottomLeft)
                + countShips(sea, topRight, new int[] { MID_X + 1, MID_Y + 1 })
                + countShips(sea, new int[] { MID_X, Y_B }, new int[] { X_A, MID_Y + 1 })
                + countShips(sea, new int[] { X_B, MID_Y }, new int[] { MID_X + 1, Y_A });
    }

    interface Sea {
        boolean hasShips(int[] topRight, int[] bottomLeft);
    }

}
