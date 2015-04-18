package com.leetcode.oj.medium;

/**
 * Created by appleowner on 4/14/15.
 */
public class MaximumSubarray {
    public static void main(String[] args) {
        System.out.println(new MaximumSubarray().maxSubArray(new int[]{-2, 1}));
    }

    public int maxSubArray(int[] A) {
        int max = A[0];
        int maxEndingHere = A[0];
        for (int i = 1; i < A.length; i++) {
            maxEndingHere = Math.max(maxEndingHere + A[i], A[i]);
            max = Math.max(max, maxEndingHere);
        }
        return max;
    }
}
