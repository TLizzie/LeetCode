package leetcode;

/**
 * Leetcode 122 BestTimetoBuyandSellStockII
 * 2019/5/21
 * time: O(n)
 * space: O(1)
 * 贪心算法 the sum of the adjacent elements is a constant value
 */
public class BestTimetoBuyandSellStockII {
    public static int maxProfit(int[] prices) {
        if (prices.length < 2 || prices == null) {
            return 0;
        }
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}
