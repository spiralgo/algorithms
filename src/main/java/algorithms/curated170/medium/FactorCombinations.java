package algorithms.curated170.medium;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import javax.swing.plaf.TreeUI;
import javax.swing.plaf.basic.BasicTreeUI.TreeCancelEditingAction;

public class FactorCombinations {
    void backtracking(int n, int index, Stack<Integer> temp, List<List<Integer>> res) {
        if (n > 1) {
            if (temp.size() >= 1) {
                temp.add(n);
                res.add(new ArrayList<>(temp));
                temp.pop();
            }
        }
        for (int i = index; i < n; ++i) {
            if (i > n / i)
                break;
            if (n % i == 0) {
                temp.add(i);
                backtracking(n / i, i, temp, res);
                temp.pop();
            }
        }
    }

    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (n < 4)
            return res;
        Stack<Integer> temp = new Stack<>();
        backtracking(n, 2, temp, res);
        return res;
    }

    public static void main(String[] args) {
        var solution = new FactorCombinations();
        for (int i = 0; i < (1 << 5); i++) {
            System.out.println("Factors of " + i + ": " + new FactorCombinations().getFactors(i));
        }
    }
}