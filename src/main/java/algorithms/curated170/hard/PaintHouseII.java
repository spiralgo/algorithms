package algorithms.curated170.hard;

public class PaintHouseII {

    public int minCostII(int[][] costs) {
        int colors = costs[0].length;

        int preMin = 0, preSecondMin = 0, preMinIdx = -1;

        for (int[] house : costs) {
            int curMin = Integer.MAX_VALUE, curSecondMin = Integer.MAX_VALUE, curMinIdx = -1;
            for (int j = 0; j < colors; j++) {

                int val = house[j] + (j == preMinIdx ? preSecondMin : preMin);

                if (curMinIdx == -1) {
                    curMin = val;
                    curMinIdx = j;
                } else if (val < curMin) {
                    curSecondMin = curMin;
                    curMin = val;
                    curMinIdx = j;
                } else if (val < curSecondMin) {
                    curSecondMin = val;
                }
            }

            preMin = curMin;
            preSecondMin = curSecondMin;
            preMinIdx = curMinIdx;
        }
        return preMin;
    }

}
