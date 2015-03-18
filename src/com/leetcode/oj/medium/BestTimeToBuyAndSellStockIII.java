package com.leetcode.oj.medium;

/**
 * Created by appleowner on 3/15/15.
 */
public class BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        int K = 2;
        int[][] Profit = new int[K + 1][prices.length];
        for (int k = 1; k <= K; k++) {
            int tmpMax = Profit[k - 1][0] - prices[0];
            for (int i = 1; i < Profit[k].length; i++) {
                Profit[k][i] = Math.max(Profit[k][i - 1], prices[i] + tmpMax);
                tmpMax = Math.max(tmpMax, Profit[k - 1][i] - prices[i]);
            }
        }
        return Profit[K][prices.length - 1];
    }
}
