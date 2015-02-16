package com.leetcode.oj.medium;

/**
 * Created by appleowner on 2/15/15.
 */
public class SingleNumberII {

    public int singleNumber(int[] A) {
        int once = 0, twice = 0;
        for (int a : A) {
            once = once ^ a & ~twice;
            twice = twice ^ a & ~once;
        }
        return once;
    }

    public static void main(String[] args) {
        System.out.print(new SingleNumberII().singleNumber(new int[]{1, 2, 1, 3, 2, 1, 2}));
    }
}
