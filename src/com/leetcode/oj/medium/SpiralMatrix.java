package com.leetcode.oj.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by appleowner on 2/2/15.
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new ArrayList<Integer>();

        int left = 0, right = matrix[0].length, top = 0, bottom = matrix.length;

        List<Integer> result = new ArrayList<Integer>();

        while (left < right && top < bottom) {
            for (int x = left; x < right; x++) {
                result.add(matrix[top][x]);
            }
            top++;
            if (left >= right || top >= bottom) break;
            for (int y = top; y < bottom; y++) {
                result.add(matrix[y][right - 1]);
            }
            right--;
            if (left >= right || top >= bottom) break;
            for (int x = right - 1; x >= left; x--) {
                result.add(matrix[bottom - 1][x]);
            }
            bottom--;
            if (left >= right || top >= bottom) break;
            for (int y = bottom - 1; y >= top; y--) {
                result.add(matrix[y][left]);
            }
            left++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{2, 3}};
        for (Integer n : new SpiralMatrix().spiralOrder(arr)) {
            System.out.format(" %2d", n);
        }
        System.out.println();
    }
}
