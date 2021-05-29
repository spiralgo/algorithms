package algorithms.curated170.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.print.attribute.standard.Sides;

public class DistanceTargetColor {

    private static final int BLUE = 1;
    private static final int GREEN = 2;
    private static final int RED = 3;

    private List<Integer> blues = new ArrayList<>();
    private List<Integer> greens = new ArrayList<>();
    private List<Integer> reds = new ArrayList<>();

    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        for (int i = 0; i < colors.length; i++) {
            int color = colors[i];
            switch (color) {
                case BLUE:
                    blues.add(i);
                    break;
                case GREEN:
                    greens.add(i);
                    break;
                case RED:
                    reds.add(i);
                    break;
            }
        }

        List<Integer> dists = new ArrayList<>();
        System.out.println(blues + "" + greens + "" + reds);
        for (int[] pair : queries) {
            int idx = pair[0];
            int searched = pair[1];
            int sIdx = -1;
            switch (searched) {
                case BLUE:
                    sIdx = Collections.binarySearch(blues, idx);
                    break;
                case GREEN:
                    sIdx = Collections.binarySearch(greens, idx);
                    break;
                case RED:
                    sIdx = Collections.binarySearch(reds, idx);
                    break;
            }
            if (sIdx < 0) {
                sIdx = -1 * (sIdx + 1);
            }
            switch (searched) {
                case BLUE:
                    sIdx = sIdx == blues.size() ? blues.get(sIdx - 1) : blues.get(sIdx);
                    break;
                case GREEN:
                    sIdx = sIdx == greens.size() ? greens.get(sIdx - 1) : greens.get(sIdx);
                    break;
                case RED:
                    sIdx = sIdx == reds.size() ? reds.get(sIdx - 1) : reds.get(sIdx);
                    break;
            }
            dists.add(sIdx);
        }

        return dists;
    }

    public static void main(String[] args) {
        var solution = new DistanceTargetColor();

        int[] colors = new int[] { 1, 1, 2, 1, 3, 2, 2, 3, 3 };
        int[][] queries = new int[][] { { 1, 3 }, { 2, 2 }, { 6, 1 } };
        System.out.println(solution.shortestDistanceColor(colors, queries));

    }
}