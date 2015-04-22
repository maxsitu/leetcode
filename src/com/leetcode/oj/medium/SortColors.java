package com.leetcode.oj.medium;

/**
 * Created by appleowner on 4/19/15.
 */
public class SortColors {
    public void sortColors(int[] A) {
        int begin = 0;
        int end = A.length - 1;
        for (int i = 0; i <= end; i++) {
            while (A[i] == 2 && i < end) {
                swap(A, i, end--);
            }
            while (A[i] == 0 && i > begin) {
                swap(A, i, begin++);
            }
        }
    }

    public void swap(int[] A, int x, int y) {
        int tmp = A[x];
        A[x] = A[y];
        A[y] = tmp;
    }
}
