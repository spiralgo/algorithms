package algorithms.curated170.medium.meetingscheduler;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class MeetingSchedulerPriorityQueue {
    List<Integer> minAvailableDuration(int[][] p1, int[][] p2, int duration) {

        Queue<int[]> intervals = new PriorityQueue<>((a, b) -> a[0] - b[0]); // sort for start time

        for (int[] interval : p1) {
            intervals.add(interval);
        }
        for (int[] interval : p2) {
            intervals.add(interval);
        }

        while (!intervals.isEmpty()) {
            int[] int1 = intervals.poll();
            int[] int2 = intervals.peek();
            if (int1[1] >= int2[0] + duration) { // If the first ends after the second begins after time of duration
                return List.of(int2[0], int2[0] + duration);
            }
        }
        return Collections.emptyList(); // If doesn't work, return empty array.
    }

    public static void main(String[] args) {

    }
}