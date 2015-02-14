package com.leetcode.oj.medium;

/**
 * Created by appleowner on 2/1/15.
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int row = 0; row < (n + 1) / 2; row++) {
            int left = row;
            int right = n - left - 1;
            for (int col = left; col < right; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[n - 1 - col][row];
                matrix[n - 1 - col][row] = matrix[n - 1 - row][n - 1 - col];
                matrix[n - 1 - row][n - 1 - col] = matrix[col][n - 1 - row];
                matrix[col][n - 1 - row] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        new RotateImage().rotate(input);
        for (int[] row : input) {
            for (int elem : row) {
                System.out.format(" %2d", elem);
            }
            System.out.println();
        }
    }
}
