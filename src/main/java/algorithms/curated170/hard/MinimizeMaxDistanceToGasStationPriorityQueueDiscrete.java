package algorithms.curated170.hard;

import java.util.PriorityQueue;

public class MinimizeMaxDistanceToGasStationPriorityQueueDiscrete {

    public double minmaxGasDist(int[] stats, int k) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        for (int i = 0; i < stats.length - 1; i++) {
            pq.offer(new double[] { stats[i + 1] - stats[i], 1 });
        }
        double maxDistance = (stats[stats.length-1] - stats[0])/(double)(k+1);
        while (k>0) {
            double[] pair = pq.poll();
            double nextLargest = pq.peek()[0];
            while(k>0 && (pair[0]>=nextLargest || pair[0]>maxDistance)){
                 pair[0] = pair[0] * pair[1] / (++pair[1]);
                 k--;
            }
           
            pq.offer(pair);
      
        }

        return pq.poll()[0];
    }

    public static void main(String[] args) {
        var solution = new MinimizeMaxDistanceToGasStationPriorityQueueDiscrete();

        System.out.println(solution.minmaxGasDist(new int[] { 1, 2, 3, 4, 5 }, 4));
    }
}
