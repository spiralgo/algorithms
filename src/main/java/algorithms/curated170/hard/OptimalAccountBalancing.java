package algorithms.curated170.hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class OptimalAccountBalancing {
    
    public int minTransfers(int[][] transactions) {
        int n = transactions.length;
        if (n == 1) {
            return 1;
        }

        int[] debt = buildDebtArray(transactions);

        Arrays.sort(debt);
        
        return cancelOppositeTransactions(debt);
        
    }
    private int cancelOppositeTransactions(int[] debt)
    {
        int m = debt.length;
        int cancelledCount = 0;
        int transactions = 0;
        boolean[] isZero = new boolean[m];

        for (int i = 0, j = m - 1; i < j;) {
            int cur = debt[i] + debt[j];

            if (cur == 0) {
                isZero[i++] = true;
                isZero[j--] = true;
                transactions++;
                cancelledCount += 2;
            } else if (cur < 0) {
                i++;
            } else {
                j--;
            }
        }

        int[] finalDebt = new int[m - cancelledCount];
        for (int i = 0, j = 0; i < m; i++) {
            if (!isZero[i]) {
                finalDebt[j++] = debt[i];
            }
        }

        return transactions + tryHandlingRemainingTransactions(0, finalDebt);
    }

    private int[] buildDebtArray(int[][] transactions) {
        Map<Integer, Integer> balances = new HashMap<>();
        
        for (int[] transaction : transactions) {
            int from = transaction[0];
            int to = transaction[1];
            int amount = transaction[2];

            balances.merge(from, -amount, Integer::sum);
            balances.merge(to, +amount, Integer::sum);
        }

        int[] debts = new int[balances.size()];
        int i = 0;

        for (int x : balances.values()) {
            if (x != 0) {
                debts[i++] = x;
            }
        }

        return Arrays.copyOf(debts, i);
    }

    private int tryHandlingRemainingTransactions(int curId, int[] debt) {
        while (curId < debt.length && debt[curId] == 0) {
            curId++;
        }

        if (curId == debt.length) {
            return 0;
        }

        int minTransactions = Integer.MAX_VALUE;

        for (int i = curId + 1; i < debt.length; i++) {
            if (debt[i] * debt[curId] < 0) {
                debt[i] += debt[curId];
                minTransactions = Math.min(minTransactions, 1 + tryHandlingRemainingTransactions(curId + 1, debt));
                debt[i] -= debt[curId];
            }
        }

        return minTransactions;
    }
}
