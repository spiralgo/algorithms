package algorithms.curated170.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimizeMaxDistanceToGasStationPriorityQueue {
    
    PriorityQueue<Interval> pq;

    public double minmaxGasDist(int[] stations, int K) {

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

        double leftToRight = stations[stations.length - 1] - stations[0];
        
        int remaining = distributeStations(stations, K, leftToRight);
        shareTheRest(remaining);

        Interval last = pq.poll();
        return last.distance();

    }

    private void shareTheRest(int remaining) {
        while (remaining > 0) {
            Interval interval = pq.poll();
            Interval nextLargest = pq.peek();
            while(remaining > 0 && interval.distance() > nextLargest.distance())
            {
                interval.numInsertions++;
                remaining--;
            }
            pq.add(interval);
        }
    }

    private int distributeStations(int[] stations, int K, double leftToRight) {
        int remaining = K;
        for (int i = 0; i < stations.length - 1; i++) {
            int numInsertions = (int) (K * calculateProportion(stations, i, leftToRight));

            pq.add(new Interval(stations[i], stations[i + 1], numInsertions));
            
            remaining -= numInsertions;
        }
        return remaining;
    }

    private double calculateProportion(int[] stations, int i, double leftToRight)
    {
        return (double) (stations[i + 1] - stations[i]) / leftToRight;
    }

    class Interval {
        double left;
        double right;
        int numInsertions;

        double distance() {
            return (right - left) / ((double) (numInsertions + 1));
        }

        Interval(double left, double right, int numInsertions) {
            this.left = left;
            this.right = right;
            this.numInsertions = numInsertions;
        }
    }

    public static void main(String[] args) {
        var solution = new MinimizeMaxDistanceToGasStationPriorityQueue();

        System.out.println(solution.minmaxGasDist(new int[] { 1, 2, 3, 4, 5 }, 4));
    }
}
