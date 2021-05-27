package algorithms.curated170.medium.meetingrooms2;

import java.util.Arrays; 

 
public class MeetingRoomsIIArray {
     public int minMeetingRooms(int[][] intervals) {
        int[] startTimes = new int[intervals.length];
        int[] endTimes = new int[intervals.length];
        
        for (int i = 0; i < intervals.length; i++) {
            startTimes[i] = intervals[i][0];
            endTimes[i] = intervals[i][1];
        }
        
        Arrays.sort(startTimes);
        Arrays.sort(endTimes);
        
        int requiredRooms = 1;
        int i = 1;
        int j = 0;
        
        while (i < intervals.length) {
            if (startTimes[i++] < endTimes[j]) {
                requiredRooms++;
            } else{
                 j++; 
            } 
               
        }
        return requiredRooms;
    }
}
