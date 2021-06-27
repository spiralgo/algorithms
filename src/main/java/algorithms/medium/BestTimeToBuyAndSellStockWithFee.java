package algorithms.medium;

public class BestTimeToBuyAndSellStockWithFee {

    public int maxProfit(int[] prices, int fee) {

        int totalProfit = 0, holdStateIncome = -1000000;
        for (int p : prices) {
            int incomeWhenSoldHere = holdStateIncome + p - fee;
            if (incomeWhenSoldHere > totalProfit) {
                totalProfit = incomeWhenSoldHere;
            } else if (totalProfit - p > holdStateIncome) {
                holdStateIncome = totalProfit - p;
            }
        }
        return totalProfit;
    }

    public static void main(String[] args) {
        var solution = new BestTimeToBuyAndSellStockWithFee();
        int[] prices = new int[] { 7, 1, 9, 3, 9, 4, 5 };
        System.out.println(solution.maxProfit(prices, 2)); // prints 10, (9-1)+(9-3)+2*(transactions), 4_5 transaction
                                                           // isn't profitable
        prices = new int[] { 7, 2, 4, 1, 2 };
        System.out.println(solution.maxProfit(prices, 2)); // prints 0, no transaction is profitable
    }
}
