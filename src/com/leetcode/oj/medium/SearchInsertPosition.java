package com.leetcode.oj.medium;

/**
 * Created by appleowner on 4/9/15.
 */
public class SearchInsertPosition {
    public int searchInsert(int[] A, int target) {
        int n = A.length;
        int begin = 0, end = n - 1;
        int mid = (begin + end) / 2;
        while (begin < end && mid > -1 && mid < n) {
            if (A[mid] == target) return mid;
            else if (A[mid] < target) begin = mid + 1;
            else end = mid - 1;
            mid = (begin + end) / 2;
        }
        if (mid < 0) return 0;
        else if (mid == n) return n;
        return (A[mid] < target) ? mid + 1 : mid;
    }
}
