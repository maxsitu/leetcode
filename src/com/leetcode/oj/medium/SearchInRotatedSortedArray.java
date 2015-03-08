package com.leetcode.oj.medium;

/**
 * Created by appleowner on 3/7/15.
 */
public class SearchInRotatedSortedArray {
    public int search(int[] A, int target) {
        for (int i = 0; i < A.length; i++) {
            if (target == A[i]) return i;
        }
        return -1;
    }

    public int search2(int[] A, int target) {
        int lo = 0;
        int hi = A.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (A[mid] > A[hi]) lo = mid + 1;
            else hi = mid;
        }

        int rot = lo;
        ;
        lo = 0;
        hi = A.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int realMid = (mid + rot) % A.length;
            if (target == A[realMid]) return realMid;
            if (A[realMid] < target) lo = mid + 1;
            else hi = mid - 1;
        }
        return -1;
    }
}
