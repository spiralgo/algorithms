package algorithms.curated170.medium.meetingscheduler;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class MeetingScheduler {
    List<Integer> minAvailableDuration(int[][] p1, int[][] p2, int duration) {

        Arrays.sort(p1, ((a, b) -> a[0] - b[0]));
        Arrays.sort(p2, ((a, b) -> a[0] - b[0]));

        int i1 = 0, i2 = 0;
        while (i1 < p1.length && i2 < p2.length) {
            int s1 = p1[i1][0], e1 = p1[i1][1], s2 = p2[i2][0], e2 = p2[i2][1]; 

            if (s2 >= e1) {
                i1++;
            } else if (s1 >= e2) {
                i2++;
                continue;
            }
            int left = Math.max(s1, s2); // lower bound of common interval
            int right = Math.min(e1, e2); // upper bound of common interval
            if (right - left >= duration) {
                return List.of(left, left + duration);
            }
            if (e2 < e1) {
                i2++;
            } else {
                i1++;
            }
        }
        return Collections.emptyList(); // If doesn't work, return empty array.
    }

    public static void main(String[] args) {

    }
}
