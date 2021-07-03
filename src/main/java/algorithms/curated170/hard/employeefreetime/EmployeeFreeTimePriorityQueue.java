package algorithms.curated170.hard.employeefreetime;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class EmployeeFreeTimePriorityQueue {

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        PriorityQueue<Interval> earliestIntervals = new PriorityQueue<Interval>((a, b) -> a.start - b.start);
        schedule.forEach(e -> earliestIntervals.addAll(e));

        int end = earliestIntervals.poll().end;
        List<Interval> commonIntervals = new ArrayList<>();

        while (!earliestIntervals.isEmpty()) {
            Interval interval = earliestIntervals.poll();

            if (interval.start > end && end >= 0) {
                commonIntervals.add(new Interval(end, interval.start));
            }
            if (interval.end > end) {
                end = interval.end;
            }
        }

        return commonIntervals;
    }

    class Interval {
        public int start;
        public int end;

        public Interval() {
        }

        public Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }
    }
}
