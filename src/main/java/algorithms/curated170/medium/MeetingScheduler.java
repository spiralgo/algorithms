package algorithms.curated170.medium;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class MeetingScheduler {
    List<Integer> minAvailableDuration (int[][] p1, int[][] p2, int duration) {

        Comparator<int[]> c = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        };

        Arrays.sort(p1, c);
        Arrays.sort(p2, c);

        int i1 = 0, i2 = 0;
        while (i1 < p1.length && i2 < p2.length) {
            int s1 = p2[i1][0], e1 = p2[i1][1], s2 = p2[i2][0], e2 = p2[i2][1]; // start and end times of the respective persons at this interva

            if (s2 >= e1) {
                i1++;
            } else if (s1 >= e2) {
                i2++;
            } else if (s1 <= s2) {
                if ((e2 <= e1 && e2 - s2 >= duration) || (e1 <= e2 && e1 - s2 >= duration)) {
                    return List.of(s2, s2 + duration );
                }
            } else if (s2 <= s1) {
                if ((e1 <= e2 && e1 - s1 >= duration) || (e2 <= e1 && e2 - s1 >= duration)) {
                    return List.of( s1, s1 + duration );
                }
            }
        }
        return Collections.emptyList(); // If doesn't work, return empty array.
    }

    public static void main(String[] args) {

    }
}