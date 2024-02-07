package algorithms.curated170.easy;
 
import java.util.Arrays;

public class MeetingRooms {
     public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MeetingRooms solution = new MeetingRooms();

        // Sample 1: Meetings do not overlap
        int[][] intervals1 = {{0, 30}, {35, 40}, {45, 50}};
        System.out.println("Can attend all meetings? (Sample 1): " + solution.canAttendMeetings(intervals1));

        // Sample 2: Meetings overlap
        int[][] intervals2 = {{0, 30}, {25, 35}, {45, 50}};
        System.out.println("Can attend all meetings? (Sample 2): " + solution.canAttendMeetings(intervals2));

        // Sample 3: No meetings
        int[][] intervals3 = {};
        System.out.println("Can attend all meetings? (Sample 3): " + solution.canAttendMeetings(intervals3));

        // Sample 4: Single meeting
        int[][] intervals4 = {{10, 20}};
        System.out.println("Can attend all meetings? (Sample 4): " + solution.canAttendMeetings(intervals4));
    }
}
