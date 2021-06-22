package algorithms.easy;

public class BestTimeToBuyAndSellStock2 {

	public int maxProfit(int[] prices) {
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
		var solution = new BestTimeToBuyAndSellStock2();
		int[] prices = new int[] { 7, 1, 5, 3, 6, 4 };

		System.out.println(solution.maxProfit(prices)); // prints 7 (1-5)+(3-6)

		prices = new int[] { 7, 6, 4, 3, 1 };
		System.out.println(solution.maxProfit(prices)); // prints 0
	}
}
