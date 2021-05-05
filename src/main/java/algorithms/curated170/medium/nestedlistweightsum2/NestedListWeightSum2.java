package algorithms.curated170.medium.nestedlistweightsum2;

import java.util.List;

public class NestedListWeightSum2 {
    int max = 1;


    public int depthSumInverse(List<NestedInteger> nestedList) {
        maxDepth(nestedList, 1);
        return dfs(nestedList, 0);
    }

   
    private void maxDepth(List<NestedInteger> nInt, int depth) {
        for (NestedInteger nestedInteger : nInt) {
            if (nestedInteger.isInteger()) max = Math.max(depth, max);
            else maxDepth(nestedInteger.getList(), depth + 1);
        }
    }
    private int dfs(List<NestedInteger> list, int depth) {
        int total = 0;
        for (NestedInteger nested : list) {
            if (nested.isInteger()) {
                total += nested.getInteger() * (max - depth);
            } else {
                total += dfs(nested.getList(), depth + 1);
            }
        }
        return total;
    }

    public static void main(String[] args) {

    }
}
