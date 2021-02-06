package algorithms.curated170;
 
import java.util.HashMap;
import java.util.Map;

public class LargestUniqueNumber {
    public int largestUniqueNumber(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : A)
        {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        int res = -1;
        for (int a : A) {
            if (map.get(a) == 1 && a > res) res = a;
        }
        return res;
    }
}
