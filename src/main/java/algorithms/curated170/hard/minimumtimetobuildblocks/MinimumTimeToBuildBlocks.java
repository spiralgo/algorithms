package algorithms.curated170.hard;

import java.util.PriorityQueue;

public class MinimumTimeToBuildBlocks {
    
    public int minBuildTime(int[] blocks, int split) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int b : blocks) pq.offer(b);
        while(pq.size() > 1)
        {
            pq.poll();
            pq.offer(pq.poll()+split);
        }
        return pq.poll();
    }
}
