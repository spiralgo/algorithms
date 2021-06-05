package algorithms.curated170.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FactorCombinations {

    List<List<Integer>> combinations;
    Stack<Integer> currFactors;

    void backtracking(int n, int index) {
        if (n > 1) {
            if (!currFactors.isEmpty()) {
                currFactors.add(n);
                combinations.add(new ArrayList<>(currFactors));
                currFactors.pop();
            }
        }

        for (int i = index; i <= n / i; i++) {
            if (n % i == 0) {
                currFactors.add(i);
                backtracking(n / i, i);
                currFactors.pop();
            }
        }
    }

    public List<List<Integer>> getFactors(int n) {
        combinations = new ArrayList<>();
        if (n < 4)
        {
            return combinations;
        }
        currFactors = new Stack<>();
        backtracking(n, 2);
        return combinations;
    }

    public static void main(String[] args) {
        var solution = new FactorCombinations();
        for (int i = 0; i < (1 << 5); i++) {
            System.out.println("Factors of " + i + ": " + new FactorCombinations().getFactors(i));
        }
    }
}