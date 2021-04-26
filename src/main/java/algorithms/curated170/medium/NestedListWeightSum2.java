package algorithms.curated170.medium;

import java.util.List;

public class NestedListWeightSum2 {
    int max = 1;

    public int solution(List<NestedInteger> nestedList) {
        for (NestedInteger n : nestedList) {
            if (!n.isInteger()) {
                max = maxDepth(n.getList(), 2);
            }
        }
        return dfs(nestedList, 0);
    }

    private int maxDepth(List<NestedInteger> nInt, int depth) {
        for (NestedInteger nested : nInt) {
            if (!nested.isInteger()) {
                depth = maxDepth(nested.getList(), depth + 1);
            }
        }
        return depth;
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
