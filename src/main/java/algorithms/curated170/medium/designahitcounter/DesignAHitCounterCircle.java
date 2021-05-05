package algorithms.curated170.medium.designahitcounter;

public class DesignAHitCounterCircle {
    public static class HitCounter {
        private int[] times;
        private int[] hits;

        //Constructor method
        public HitCounter() {
            times = new int[300];
            hits = new int[300];
        }

        public void hit(int timestamp) {
            int i = timestamp % 300;
            if (times[i] != timestamp) {
                times[i] = timestamp;
                hits[i] = 1;
            } else {
                hits[i]++;
            }
        }

        // Time Complexity : O(1), does 300 computations each time. 
        public int getHits(int timestamp) {
            int hitCount = 0;
            for (int i = 0; i < 300; ++i) {
                if (timestamp - times[i] < 300) {
                    hitCount += hits[i];
                }
            }
            return hitCount;
        }
    }

    public static void main(String[] args) {
        var hitCounter = new HitCounter();
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
