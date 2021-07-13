package algorithms.hard;

public class BestTimeToBuyAndSellStockIV {

	public int maxProfit(int k, int[] prices) {
		final int LEN = prices.length;
		if (k >= (LEN / 2)) {
			return maxProfitNoTransactionLimit(prices);
		}

		int[] currBest = new int[LEN];
		int[] prevBest = new int[LEN];

		for (int i = 1; i <= k; i++) {
			int holdStateIncome = -prices[0];
			for (int j = 1; j < LEN; j++) {
				currBest[j] = Math.max(currBest[j - 1], prices[j] + holdStateIncome);
				holdStateIncome = Math.max(holdStateIncome, prevBest[j - 1] - prices[j]);
			}
			prevBest = currBest;
			currBest = new int[LEN];
		}

		return prevBest[LEN - 1];
	}

	private int maxProfitNoTransactionLimit(int[] prices) {
		int totalProfit = 0;
		for (int i = 1; i < prices.length; i++) {
			int profitIncrement = prices[i] - prices[i - 1];
			if (profitIncrement > 0) {
				totalProfit += profitIncrement;
			}
		}
		return totalProfit;
	}

	public static void main(String[] args) {
		int[] prices = { 3, 2, 6, 5, 0, 3, 1, 4, 9 };
		var solution = new BestTimeToBuyAndSellStockIV();
		System.out.println(solution.maxProfit(3, prices)); // 2-6, 0-3, 1-9 => 15
	}
}
