package algorithms.curated170.medium;

import java.util.Collection;
import java.util.List;

public class FindTheCelebrity {

    public int maxDistance(List<List<Integer>> arrays) {
        
        int min = 1000000000, max = -1000000000;
        int maxDist = 0;

        for (List<Integer> list : arrays) {
            int first = list.get(0);
            int last = list.get(list.size() - 1);

            maxDist = Math.max(maxDist, max - first);
            maxDist = Math.max(maxDist, last - min);

            min = Math.min(min, first);
            max = Math.max(max, last);
        }

        return maxDist;
    }

}