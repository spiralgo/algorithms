package algorithms.hard;

public class BestTimeToBuyAndSellStockIII {

    public int maxProfit(int[] prices) {
		int currBuy1 = Integer.MAX_VALUE, maxProfit1 = 0;
		int currBuy2 = Integer.MAX_VALUE, maxProfit2 = 0;
        for (int p : prices) {
			if (p < currBuy1) {
				currBuy1 = p;
			} else {
				maxProfit1 = Math.max(maxProfit1, p - currBuy1);
			}
            
            int secondBuyCost = p - maxProfit1;
            if (secondBuyCost < currBuy2) {
				currBuy2 = secondBuyCost;
			} else {
				maxProfit2 = Math.max(maxProfit2, p - currBuy2);
			}

		}
		return maxProfit2;
	}

    public static void main(String[] args) {
        int[] nums = {7,2,5,10,8, 12, 3, 4, 9, 5, 7, 4};
        var solution = new BestTimeToBuyAndSellStockIII();
    }
}
