package com.leetcode.oj.medium;

/**
 * Created by appleowner on 3/26/15.
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int A[], int B[]) {
        int lenA = A.length;
        int lenB = B.length;
        if (lenA > lenB) return findMedianSortedArrays(B, A);
        int iMin = 0, iMax = lenA;
        int i = (iMin + iMax) / 2;
        int j = (lenA + lenB + 1) / 2 - i;
        while (iMin <= iMax) {
            i = (iMin + iMax) / 2;
            j = (lenA + lenB + 1) / 2 - i;
            if (i < lenA && j > 0 && A[i] < B[j - 1]) {
                iMin = i + 1;
            } else if (i > 0 && j < lenB && A[i - 1] > B[j]) {
                iMax = i - 1;
            } else {
                break;
            }
        }
        int num1;
        if (i == 0) num1 = B[j - 1];
        else if (j == 0) num1 = A[i - 1];
        else num1 = Math.max(A[i - 1], B[j - 1]);

        if ((lenA + lenB) % 2 == 1) return num1;

        int num2;
        if (i == lenA) num2 = B[j];
        else if (j == lenB) num2 = A[i];
        else num2 = Math.min(A[i], B[j]);

        return (num1 + num2) / 2.0;
    }

    public static void main(String[] args) {
        System.out.println(new MedianOfTwoSortedArrays().findMedianSortedArrays(new int[0], new int[]{2, 3}));
    }
}
