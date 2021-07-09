package algorithms.medium;

public class CapacityToShipPackagesWithinDDays {

    public int shipWithinDays(int[] weights, final int D) {
        int minC = 0;
        int maxC = 500 * weights.length / D + 1;

        while (minC < maxC) {
            final int MID = (minC + maxC) / 2;
            if (canShipInDDays(weights, D, MID)) {
                maxC = MID;
            } else {
                minC = MID + 1;
            }
        }

        return minC;
    }

    private boolean canShipInDDays(int[] weights, final int D, final int MID) {
        int days = 1;
        int load = 0;

        for (int w : weights) {
            if (w > MID) {
                return false;
            }
            if (load + w > MID) {
                if (++days > D) {
                    return false;
                }

                load = w;
                continue;
            }

            load += w;
        }

        return days <= D;
    }
}
