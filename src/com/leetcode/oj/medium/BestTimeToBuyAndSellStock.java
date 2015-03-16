package com.leetcode.oj.medium;

/**
 * Created by appleowner on 3/15/15.
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int min = prices[0];
        int max = 0;
        for (int price : prices) {
            if (price - min > max) max = price - min;
            if (price < min) min = price;
        }
        return max;
    }
}
