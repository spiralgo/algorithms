package algorithms.curated170.medium;

import java.util.HashMap;
import java.util.List;

class NestedIntegerWeightSum2Hashmap {
    HashMap<Integer, Integer> deepSumMap = new HashMap<>();
    int max = 1;

    public int depthSumInverse(List<NestedInteger> nestedList) {
        maxDepth(nestedList, 1);
        return sumMapTotal();
    }

    private void maxDepth(List<NestedInteger> nInt, int depth) {
        for (NestedInteger nestedInteger : nInt) {
            if (nestedInteger.isInteger()) {
                deepSumMap.put(depth, deepSumMap.get(depth)+nestedInteger.getInteger());
                max = Math.max(depth, max);
            } else
                maxDepth(nestedInteger.getList(), depth + 1);
        }
    }

    private int sumMapTotal() {
        int total = 0;
        for(int i : deepSumMap.keySet())
        {
            total += deepSumMap.get(i) * (max-i+1);
        }
        return total;
    }

    public static void main(String[] args) {

    }
}