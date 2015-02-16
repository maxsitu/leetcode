package com.leetcode.oj.medium;

/**
 * Created by appleowner on 2/15/15.
 */
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        int ret = 0;
        if (n == 0 || n == 1) return 1;
        else {
            for (int i = 0; i < n / 2; i++) {
                ret += numTrees(i) * numTrees(n - 1 - i);
            }
            ret *= 2;
            if (n % 2 == 1) ret += numTrees(n / 2) * numTrees(n / 2);
            return ret;
        }
    }
}
