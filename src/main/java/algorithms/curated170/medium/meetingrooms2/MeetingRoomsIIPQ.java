package algorithms.curated170.medium.meetingrooms2;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsIIPQ {

    public int minMeetingRooms(int[][] intervals) {
        PriorityQueue<Integer> endTimes = new PriorityQueue();
        int requiredRooms = 1;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < intervals.length - 1; i++) {
            endTimes.add(intervals[i][1]);
        }

        for (int i = 0; i < intervals.length - 1; i++) {
            int currentMinimumEnd = endTimes.poll();

            if (currentMinimumEnd > intervals[i + 1][0]) {
                requiredRooms++;
                endTimes.add(currentMinimumEnd);
            }
        }

        return requiredRooms;
    }
}
