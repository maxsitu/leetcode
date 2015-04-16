package com.leetcode.oj.medium;

/**
 * Created by appleowner on 4/15/15.
 */
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int top = 0, bottom = n - 1, left = 0, right = n - 1;
        int num = 1;
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                res[top][i] = num++;
            }
            top++;
            if (top > bottom || left > right) break;
            for (int i = top; i <= bottom; i++) {
                res[i][right] = num++;
            }
            right--;
            if (top > bottom || left > right) break;
            for (int i = right; i >= left; i--) {
                res[bottom][i] = num++;
            }
            bottom--;
            if (top > bottom || left > right) break;
            for (int i = bottom; i >= top; i--) {
                res[i][left] = num++;
            }
            left++;
        }
        return res;
    }
}
