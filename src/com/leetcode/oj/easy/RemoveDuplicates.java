package com.leetcode.oj.easy;

/**
 * Created by appleowner on 4/3/15.
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] A) {
        if (A.length < 2) return A.length;
        int slow = 0;
        int fast = 1;
        while (fast < A.length) {
            while (fast < A.length && A[slow] == A[fast]) fast++;
            if (fast < A.length) {
                slow++;
                A[slow] = A[fast];
            }
        }
        return slow + 1;
    }
}
