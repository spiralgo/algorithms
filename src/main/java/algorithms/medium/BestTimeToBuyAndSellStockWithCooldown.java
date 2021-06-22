package algorithms.medium;

public class BestTimeToBuyAndSellStockWithCooldown {

    public int maxProfit(int[] prices) {

        int totalProfit = 0, restProfit = 0, currBuyCosts = Integer.MIN_VALUE;
        for (int p : prices) {
            int prevBest = totalProfit;
            totalProfit = Math.max(totalProfit, currBuyCosts + p);
            currBuyCosts = Math.max(currBuyCosts, restProfit - p);
            restProfit = Math.max(restProfit, prevBest);
        }
        return totalProfit;
    }

    public static void main(String[] args) {
        var solution = new BestTimeToBuyAndSellStockWithCooldown();
        int[] prices = new int[] { 7, 1, 9, 3, 9, 4 };
        System.out.println(solution.maxProfit(prices)); // prints 9, 3_9 transaction can't take place
        prices = new int[] { 7, 6, 4, 3, 1 };
        System.out.println(solution.maxProfit(prices)); // prints 0
    }
}
