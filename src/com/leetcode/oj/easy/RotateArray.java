package com.leetcode.oj.easy;

import java.util.Arrays;

/**
 * Created by v545192 on 2/25/2015.
 */
public class RotateArray {
    public static void main(String[] args) {
        int[] result = new int[]{1, 2, 3, 4, 5, 6, 7};
        new RotateArray().rotate(result, 3);
        for (int n : result) {
            System.out.format("%d ", n);
        }
    }

    public void rotate(int[] nums, int k) {
        int len = nums.length;
        if (len == 0) return;
        k = k % len;
        int[] tail = Arrays.copyOfRange(nums, len - k, len);
        for (int i = len - k - 1; i >= 0 && k != 0; i--) {
            nums[i + k] = nums[i];
        }
        for (int i = 0; i < k; i++) {
            nums[i] = tail[i];
        }
    }
}
