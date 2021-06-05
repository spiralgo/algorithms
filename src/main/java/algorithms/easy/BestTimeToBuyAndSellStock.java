package algorithms.easy;

public class BestTimeToBuyAndSellStock {

	public int maxProfit(int[] prices) {
		int currBuy = Integer.MAX_VALUE, maxProfit = 0;
		for (int p : prices) {
			if (p > currBuy) {
				currBuy = p;
			} else {
				maxProfit = Math.max(maxProfit, p - currBuy);
			}
		}
		return maxProfit;
	}

	public static void main(String[] args) {
		var solution = new BestTimeToBuyAndSellStock();
		int[] prices = new int[] { 7, 1, 5, 3, 6, 4 };
		System.out.println(solution.maxProfit(prices)); // prints 5 (6-1)
		prices = new int[] { 7, 6, 4, 3, 1 };
		System.out.println(solution.maxProfit(prices)); // prints 0
	}
}