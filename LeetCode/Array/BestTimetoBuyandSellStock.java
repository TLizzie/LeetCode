package LeetCode.Array;

/**
 * Leetcode 121 BestTimetoBuyandSellStock
 * 2019/5/21
 * time: O(n)
 * space: O(1)
 */
public class BestTimetoBuyandSellStock {
    public static int maxProfit(int[] prices) {
        if (prices.length < 2 || prices == null) {
            return 0;
        }
        int min = prices[0];
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            profit = Math.max(profit, prices[i] - min);

        }
        return profit;
    }
}
