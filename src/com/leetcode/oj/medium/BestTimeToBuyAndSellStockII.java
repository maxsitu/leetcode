package com.leetcode.oj.medium;

/**
 * Created by appleowner on 3/15/15.
 */
public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) sum += prices[i + 1] - prices[i];
        }
        return sum;
    }
}
