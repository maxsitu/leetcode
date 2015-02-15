package com.leetcode.oj.medium;

/**
 * Created by appleowner on 2/15/15.
 */
public class SingleNumber {

    public int singleNumber(int[] A) {
        int result = 0;
        for (int a : A) {
            result ^= a;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.print(new SingleNumber().singleNumber(new int[]{1, 1, 3, 3, 4, 5, 6, 5, 4}));
    }
}
