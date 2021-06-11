package algorithms.curated170.hard;

import java.util.PriorityQueue;

public class MinimizeMaxDistanceToGasStationPriorityQueue {

    public double minmaxGasDist(int[] stats, int k) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        for (int i = 0; i < stats.length - 1; i++) {
            pq.offer(new double[] { stats[i + 1] - stats[i], 1 });
        }
        
        for (int i = 0; i < k; i++) {
            double[] pair = pq.poll();

            pair[0] = pair[0] * pair[1] / (++pair[1]);

            pq.offer(pair);
        }

        return pq.poll()[0];
    }

    public static void main(String[] args) {
        var solution = new MinimizeMaxDistanceToGasStationPriorityQueue();

        System.out.println(solution.minmaxGasDist(new int[] { 1, 2, 3, 4, 5 }, 4));
    }
}
