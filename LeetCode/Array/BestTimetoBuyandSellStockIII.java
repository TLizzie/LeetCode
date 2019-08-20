package LeetCode.Array;

/**
 * Leetcode 122 BestTimetoBuyandSellStockII
 * hard 难度 看看就完了……
 * 2019/5/22
 * time: O(n)
 * space: O(1)
 * 动态规划
 * */

public class BestTimetoBuyandSellStockIII {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE;
        int sell1 = 0, sell2 = 0;
        for (int price : prices) {
            sell2 = Math.max(buy2 + price, sell2);
            buy2 = Math.max(buy2, sell1 - price);
            sell1 = Math.max(sell1, buy1 + price);
            buy1 = Math.max(-price, buy1);
        }
        return sell2;
    }
}
