package algorithms.curated170.medium.designahitcounter;

import java.util.LinkedList;
import java.util.List;

public class DesignAHitCounter {
    public static class HitCounter {
        private List<Integer> hits = new LinkedList<>();

        public HitCounter() {
        }

        public void hit(int time) {
            hits.add(time);
        }

        public int getHits(int timestamp) {
            int size = hits.size();   
            int l = timestamp <= 300 ? 0 : timestamp - 300;
    
            int index = 0;
            for (int i: hits) {
                if (i <= l) {
                    index++;
                }else break;
            }
            
            return size - index;
        }

        //Another way of solving:
        public int getHitsWithBinarySearch(int time) {
            adjustValidHits(time);
            return hits.size();
        }

        private void adjustValidHits(int time) {
            int size = hits.size();
            if (size==0 || time - hits.get(0) < 300 ) {
                return;
            }
            if (time - hits.get(size - 1) >= 300) {
                hits.clear();
                return;
            }
            int l = 0, r = size;
            while (r >= l) {
                int mid = (l + r) / 2;
                if (time - hits.get(mid) >= 300) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            hits = hits.subList(l, size);
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
        System.out.println(hitCounter.getHits(301)); //prints 8
        System.out.println(hitCounter.getHits(305)); //prints 6
    }
}
