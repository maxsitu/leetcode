package com.leetcode.oj.medium;

/**
 * Created by appleowner on 2/4/15.
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        if (m < n) {
            int tmp = m;
            m = n;
            n = tmp;
        }
        long mul = 1;
        for (int i = m; i <= m + n - 2; i++) {
            mul *= i;
        }

        for (int i = n - 1; i > 0; i--) {
            mul /= i;
        }
        return (int) mul;
    }

    public static void main(String[] args) {
        System.out.println(new UniquePaths().uniquePaths(10, 10));
    }
}
