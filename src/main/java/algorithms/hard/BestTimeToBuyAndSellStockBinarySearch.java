package algorithms.hard;

public class BestTimeToBuyAndSellStockBinarySearch {

	final int TOO_MANY_TRANSACTIONS = -1;
	public int maxProfit(int k, int[] prices) {
		if (k >= (prices.length / 2)) {
			return maxProfitNoTransactionLimit(prices);
		}

		int lo = 0, hi = 1000;
		int totalProfit = 0;
		while (lo < hi) {
			int mid = (lo + hi) / 2;
			int profit = countProfitWithSellBoundary(mid, prices, k);
			if (profit != TOO_MANY_TRANSACTIONS) {
				totalProfit = profit + mid * k;
				hi = mid;
			} else {
				lo = mid + 1;
			}
		}
		return totalProfit;
	}

	private int countProfitWithSellBoundary(int sellLimit, int[] prices, int k) {
		int holdIncome = -prices[0], holdCount = 0;
		int sellsProfit = 0, sellsCount = 0;

		for (int i = 1; i < prices.length; i++) {
			int price = prices[i];
			if (holdIncome + price - sellLimit > sellsProfit) {
				sellsProfit = holdIncome + price - sellLimit;
				sellsCount = holdCount + 1;
			}
			if (sellsProfit - price > holdIncome) {
				holdIncome = sellsProfit - price;
				holdCount = sellsCount;
			}
		}
		return sellsCount > k ? TOO_MANY_TRANSACTIONS : sellsProfit;
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
		var solution = new BestTimeToBuyAndSellStockBinarySearch();
		System.out.println(solution.maxProfit(3, prices)); // 2-6, 0-3, 1-9 => 15
	}
}
