package algorithms.easy;

public class BestTimeToBuyAndSellStock {

	public int maxProfit(int[] prices) {
		int buy = Integer.MAX_VALUE, sell = 0;
		for (int p : prices) {
			buy = Math.min(p, buy);
			sell = Math.max(sell, p - buy);
		}
		return sell;
	}

	public static void main(String[] args) {
		var solution = new BestTimeToBuyAndSellStock();
		int[] prices = new int[]{7,1,5,3,6,4};
		System.out.println(solution.maxProfit(prices));  // prints 5 (6-1)
		prices = new int[]{7,6,4,3,1};
		System.out.println(solution.maxProfit(prices));  // prints 0
	}
}