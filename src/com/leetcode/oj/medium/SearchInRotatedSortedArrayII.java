package com.leetcode.oj.medium;

/**
 * Created by appleowner on 3/7/15.
 */
public class SearchInRotatedSortedArrayII {
    public boolean search(int[] A, int target) {
        int l = 0;
        int r = A.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (A[mid] == target) return true;
            if (A[l] < A[mid]) {
                if (target < A[mid] && A[l] <= target) {
                    r = mid - 1;
                } else l = mid + 1;
            } else if (A[l] > A[mid]) {
                if (A[mid] < target && target <= A[r]) {
                    l = mid + 1;
                } else r = mid - 1;
            } else l++;
        }
        return false;
    }
}
