package algorithms.curated170.hard;

public class OptimalAccountBalancing {

    public int minTransfers(int[][] transactions) {
        if (transactions == null || transactions.length == 0 || transactions[0].length == 0) {
            return 0;
        }
        
        int n = transactions.length;
        if (n == 1) {
            return 1;
        }
        
        int[] debt = buildDebtArray(transactions);
        
        int m = debt.length;
        Arrays.sort(debt);
        int zeroNum = 0;
        int res = 0;
        boolean[] isZero = new boolean[m];
        for (int i = 0, j = m - 1; i < j;) {
            int cur = debt[i] + debt[j];
            if (cur == 0) {
                isZero[i++] = true;
                isZero[j--] = true;                
                res++;
                zeroNum += 2;
            } else if (cur < 0) {
                i++;
            } else {
                j--;
            }
        }
        int[] finalDebt = new int[m - zeroNum];
        for (int i = 0, j = 0; i < m; i++) {
            if (!isZero[i]) {
                finalDebt[j++] = debt[i];
            }
        }
        
        return res + backtrack(0, finalDebt);
    }
    
    private int[] buildDebtArray(int[][] transactions) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] curTran: transactions) {
            int from = curTran[0];
            int to = curTran[1];
            int amount = curTran[2];
            map.put(from, map.getOrDefault(from, 0) - amount);
            map.put(to, map.getOrDefault(to, 0) + amount);
        }
        int[] res = new int[map.size()];
        int i = 0;
        for (int x: map.values()) {
            if (x != 0) {
                res[i++] = x;
            }
        }
        return Arrays.copyOf(res, i);
    }
    
    private int backtrack(int curId, int[] debt) {
        while (curId < debt.length && debt[curId] == 0) {
            curId++;
        }
        // Base case.
        if (curId == debt.length) {
            return 0;   
        }            
        // Recursive case.
        int min = Integer.MAX_VALUE;
        for (int i = curId + 1; i < debt.length; i++) {
            if (debt[i] * debt[curId] < 0) {
                debt[i] += debt[curId];
                min = Math.min(min, 1 + backtrack(curId + 1, debt));
                debt[i] -= debt[curId];
            }
        }
        
        return min;
    }


}
