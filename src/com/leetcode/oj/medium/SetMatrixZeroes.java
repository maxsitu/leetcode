package com.leetcode.oj.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by appleowner on 4/18/15.
 */
public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = (m == 0) ? 0 : matrix[0].length;
        Set<Integer> zeroRowSet = new HashSet<>();
        Set<Integer> zeroColSet = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    zeroRowSet.add(i);
                    zeroColSet.add(j);
                }
            }
        }
        for (int row : zeroRowSet) {
            for (int i = 0; i < n; i++) matrix[row][i] = 0;
        }
        for (int col : zeroColSet) {
            for (int i = 0; i < m; i++) matrix[i][col] = 0;
        }
    }
}
