package algorithms.curated170.hard.employeefreetime;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeFreeTimeSorting {

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> earliestIntervals = new ArrayList<>();
        schedule.forEach(e -> earliestIntervals.addAll(e));
        Collections.sort(earliestIntervals, (a, b) -> a.start - b.start);

        int end = -1;
        List<Interval> commonIntervals = new ArrayList<>();
        for (var interval : earliestIntervals) {
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
