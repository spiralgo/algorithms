package algorithms.curated170.medium.nestedlistweightsum2;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NestedListWeightSum2Queue {

    public int depthSumInverse(List<NestedInteger> nestedList) {

        Queue<NestedInteger> productionLine = new LinkedList<>();

        for (NestedInteger nestedInteger : nestedList) {
            productionLine.add(nestedInteger);
        }

        int totalSum = 0;
        int layerSum = 0;
        while (!productionLine.isEmpty()) {
            int size = productionLine.size();
            int individualSum = 0;
            for (int i = 0; i < size; i++) {

                NestedInteger nestedInteger = productionLine.poll();

                if (nestedInteger.isInteger()) {
                    individualSum += nestedInteger.getInteger();

                } else {
                    List<NestedInteger> pack = nestedInteger.getList();
                    productionLine.addAll(pack);
                }

            }
            layerSum += individualSum;
            totalSum += layerSum;

        }
        return totalSum;
    }

}
