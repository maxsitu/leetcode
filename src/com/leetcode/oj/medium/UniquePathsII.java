package com.leetcode.oj.medium;

/**
 * Created by appleowner on 4/16/15.
 */
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] rec = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)
                    rec[i][j] = 0;
                else if (i == 0 && j == 0)
                    rec[i][j] = 1;
                else if (i == 0)
                    rec[i][j] = rec[i][j - 1];
                else if (j == 0)
                    rec[i][j] = rec[i - 1][j];
                else rec[i][j] = rec[i - 1][j] + rec[i][j - 1];
            }
        }
        return rec[m - 1][n - 1];
    }
}
