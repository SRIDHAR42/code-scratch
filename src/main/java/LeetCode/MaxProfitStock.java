package LeetCode;

public class MaxProfitStock {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int maxProfit = -1;
        int max = prices[prices.length -1];
        for (int i = prices.length -2; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            maxProfit = Math.max(maxProfit, max - prices[i]);
        }
        return maxProfit;
    } // https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
}
