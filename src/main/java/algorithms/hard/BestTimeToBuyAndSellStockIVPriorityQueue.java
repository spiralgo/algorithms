package algorithms.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class BestTimeToBuyAndSellStockIVPriorityQueue {

	public int maxProfit(int k, int[] prices) {
		final int LEN = prices.length;
		if (k < 1 || prices == null || LEN == 0)
			return 0;

		PriorityQueue<Integer> profits = new PriorityQueue<>((a, b) -> b - a);
		Stack<Integer> starts = new Stack<>();
		Stack<Integer> ends = new Stack<>();
		int s, e = 0;

		while (e < LEN) {
			s = e;
			while (s + 1 < LEN && prices[s] >= prices[s + 1]) {
				s++;
			}

			e = s + 1;
			while (e + 1 < LEN && prices[e] <= prices[e + 1]) {
				e++;
			}
			
			if (s < e && s < LEN && e < LEN) {
				findMaxRanges(prices, profits, starts, ends, s, e);
			}
		}

		while (!starts.isEmpty()) {
			profits.add(prices[ends.pop()] - prices[starts.pop()]);
		}

		int totalProfit = 0;
		for (int t = 0; t < k && !profits.isEmpty(); t++) {
			totalProfit += profits.poll();
		}

		return totalProfit;
	}

	private void findMaxRanges(int[] prices, PriorityQueue<Integer> profits, Stack<Integer> starts, Stack<Integer> ends,
			int s, int e) {
		while (!starts.isEmpty() && prices[s] < prices[starts.peek()]) {
			profits.add(prices[ends.pop()] - prices[starts.pop()]);
		}

		while (!starts.isEmpty() && prices[e] >= prices[ends.peek()]) {
			profits.add(prices[ends.pop()] - prices[s]);
			s = starts.pop();
		}
		starts.push(s);
		ends.push(e);
	}

	public static void main(String[] args) {
		int[] prices = { 3, 2, 6, 5, 0, 3, 1, 4, 9 };
		var solution = new BestTimeToBuyAndSellStockIVPriorityQueue();
		System.out.println(solution.maxProfit(3, prices)); // 2-6, 0-3, 1-9 => 15

		prices = new int[] { 2, 3, 1, 4, 12 };
		System.out.println(solution.maxProfit(1, prices)); // 1-12 => 11

		prices = new int[] { 1, 5, 7, 4, 12 };
		System.out.println(solution.maxProfit(1, prices)); // 1-12 => 11

		prices = new int[] { 1, 5, 4, 7, 5, 27 };
		System.out.println(solution.maxProfit(1, prices)); // 1-27 => 26
	}
}
