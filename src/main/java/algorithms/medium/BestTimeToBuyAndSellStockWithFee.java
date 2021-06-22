package algorithms.medium;

public class BestTimeToBuyAndSellStockWithFee {

    public int maxProfit(int[] prices, int fee) {

        int totalProfit = 0, currBuyCosts = Integer.MIN_VALUE;
        for (int p : prices) {
            totalProfit = Math.max(totalProfit, currBuyCosts+p-fee);
            currBuyCosts = Math.max(currBuyCosts, totalProfit-p);
        }
        return totalProfit;
    }

    public static void main(String[] args) {
        var solution = new BestTimeToBuyAndSellStockWithFee();
        int[] prices = new int[] { 7, 1, 9, 3, 9, 4, 5 };
        System.out.println(solution.maxProfit(prices, 2)); // prints 10, (9-1)+(9-3)+2*(transactions), 4_5 transaction isn't profitable
        prices = new int[] { 7, 2, 4, 1, 2 };
        System.out.println(solution.maxProfit(prices, 2)); // prints 0
    }
}
