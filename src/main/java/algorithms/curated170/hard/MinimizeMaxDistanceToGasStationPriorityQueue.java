package algorithms.curated170.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimizeMaxDistanceToGasStationPriorityQueue {
    
    PriorityQueue<Interval> pq;

    public double minmaxGasDist(final int[] stats, final int K) {

            pq = new PriorityQueue<Interval>(new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {

                double diff = a.distance() - b.distance();
                if (diff < 0) {
                    return +1;
                } else if (diff > 0) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        

        int remaining = distributeStations(stats, K);

        shareTheRest(remaining);

        Interval last = pq.poll();
        return last.distance();

    }

    private void shareTheRest(int remaining) {
        while (remaining > 0) {
            Interval interval = pq.poll();
            interval.numInsertions++;
            pq.add(interval);
            remaining--;
        }
    }

    private int distributeStations(final int[] stats, final int K) {
        int remaining = K;
        final double intervalPlacementSubrange = K / (stats[stats.length - 1] - stats[0]);

        for (int i = 0; i < stats.length - 1; i++) {
            int numInsertions = (int) ((stats[i + 1] - stats[i])*intervalPlacementSubrange);

            pq.add(new Interval(stats[i], stats[i + 1], numInsertions));
            
            remaining -= numInsertions;
        }
        return remaining;
    }

    class Interval {
        final double length;
        int numInsertions;

        double distance() {
            return length / (numInsertions + 1);
        }

        Interval(double left, double right, int numInsertions) {
            length = right - left;
            this.numInsertions = numInsertions;
        }
    }

    public static void main(String[] args) {
        var solution = new MinimizeMaxDistanceToGasStationPriorityQueue();

        System.out.println(solution.minmaxGasDist(new int[] { 1, 2, 3, 4, 5 }, 4));
        System.out.println(solution.minmaxGasDist(new int[] { 0, 100, 150}, 4));
    }
}
