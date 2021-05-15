package algorithms.curated170.medium.meetingscheduler;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class MeetingSchedulerPriorityQueue {
    Queue<int[]> intervals;

    List<Integer> minAvailableDuration(int[][] p1, int[][] p2, int duration) {

        createHeap(p1, p2, duration);

         while (intervals.size() > 1) {  //   When we poll from the queue, there should be any possibility that it is empty.
            int[] int1 = intervals.poll();
            int[] int2 = intervals.peek();
            if (int1[1] >= int2[0] + duration) { // If the first ends after the second begins after time of duration
                return List.of(int2[0], int2[0] + duration);
            }
        }
        return Collections.emptyList(); // If doesn't work, return empty array.
    }

    private Queue<int[]> createHeap(int[][] p1, int[][] p2, int duration) {
        intervals = new PriorityQueue<>((a, b) -> a[0] - b[0]); // sort for start time

        for (int[] interval : p1) {
            if (interval[1] - interval[0] >= duration) {
                intervals.add(interval);
            }
        }
        for (int[] interval : p2) {
            if (interval[1] - interval[0] >= duration) {
                intervals.add(interval);
            }
        }
        return intervals;
    }

    public static void main(String[] args) {

    }
}
