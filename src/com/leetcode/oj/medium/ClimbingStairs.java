package com.leetcode.oj.medium;

/**
 * Created by appleowner on 4/18/15.
 */
public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(new ClimbingStairs().climbStairs(20));
    }

    public int climbStairs(int n) {
        if (n == 1) return 1;
        else if (n == 2) return 2;

        int n_2 = 1;
        int n_1 = 2;
        for (int i = 3; i <= n; i++) {
            int tmp = n_2 + n_1;
            n_2 = n_1;
            n_1 = tmp;
        }
        return n_1;
    }
}
