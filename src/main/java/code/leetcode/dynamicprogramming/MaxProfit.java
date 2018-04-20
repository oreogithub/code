package code.leetcode.dynamicprogramming;

public class MaxProfit {
	public int maxProfit(int[] prices) {
		int profit = 0;
		int max = prices.length - 1, min = prices.length - 2;
		for (int i = prices.length - 1; i > 0; i--) {
			if (prices[i] > prices[max])
				max = i;
			else if (prices[i] < prices[min])
				min = i;
		}
		return profit;
	}
}
