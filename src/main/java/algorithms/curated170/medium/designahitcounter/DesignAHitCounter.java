package algorithms.curated170.medium.designahitcounter;

import java.util.LinkedList;
import java.util.Queue;

public class DesignAHitCounter {
    public class HitCounter {

        private Queue<Integer> hits;

        public HitCounter() {
            hits = new LinkedList<>();
        }

        public void hit(int time) {
            hits.add(time);
        }

        public int getHits(int timestamp) {
            while (!hits.isEmpty() && timestamp - hits.peek() >= 300) {
                hits.poll();
            }
            return hits.size();
        }
    }

    public static void main(String[] args) {
        var solution = new DesignAHitCounter();
        var hitCounter = solution.new HitCounter();

        hitCounter.hit(1);
        hitCounter.hit(2);
        hitCounter.hit(3);
        hitCounter.hit(10);
        hitCounter.hit(10);
        hitCounter.hit(12);
        hitCounter.hit(13);
        hitCounter.hit(13);
        hitCounter.hit(302);
        System.out.println(hitCounter.getHits(301)); // prints 8
        System.out.println(hitCounter.getHits(305)); // prints 6
    }
}
