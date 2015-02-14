package com.leetcode.oj.medium;

/**
 * Created by appleowner on 2/5/15.
 */
public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (matrix[0][0] > target || matrix[m - 1][n - 1] < target) return false;
        int row = 0;
        while (row < m && matrix[row][0] <= target) {
            row++;
        }
        row--;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (matrix[row][mid] == target) return true;
            else if (matrix[row][mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new SearchA2DMatrix().searchMatrix(new int[][]{{1}, {3}}, 1));
    }
}
