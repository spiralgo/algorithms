package algorithms.curated170.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FactorCombinations {

    List<List<Integer>> res;
    Stack<Integer> temp;

    void backtracking(int n, int index) {
        if (n > 1) {
            if (temp.size() >= 1) {
                temp.add(n);
                res.add(new ArrayList<>(temp));
                temp.pop();
            }
        }

        for (int i = index; i <= n / i; ++i) {
            if (n % i == 0) {
                temp.add(i);
                backtracking(n / i, i);
                temp.pop();
            }
        }
    }

    public List<List<Integer>> getFactors(int n) {
        res = new ArrayList<>();
        if (n < 4)
        {
            return res;
        }
        temp = new Stack<>();
        backtracking(n, 2);
        return res;
    }

    public static void main(String[] args) {
        var solution = new FactorCombinations();
        for (int i = 0; i < (1 << 5); i++) {
            System.out.println("Factors of " + i + ": " + new FactorCombinations().getFactors(i));
        }
    }
}