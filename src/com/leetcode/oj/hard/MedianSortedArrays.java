package com.leetcode.oj.hard;

/**
 * Created by appleowner on 1/18/15.
 */
public class MedianSortedArrays {
    public double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length;
        int n = B.length;
        if ((m + n) % 2 == 1) {
            return findKth(A, B, 0, m, 0, n, (m + n + 1) / 2);
        } else {
            return (findKth(A, B, 0, m, 0, n, (m + n) / 2) + findKth(A, B, 0, m, 0, n, (m + n) / 2 + 1)) / 2.0;
        }

    }

    public double findKth(int A[], int B[], int al, int ar, int bl, int br, int k) {
        int m = ar - al;
        int n = br - bl;
        if (m > n) {
            findKth(B, A, bl, br, al, ar, k);
        }
        if (m == 0) {
            return B[bl + k - 1];
        }

        if (k == 1) {
            return Math.min(A[al], B[bl]);
        }

        if (m == 1) {
            if (A[0] <= B[0]) {
                return B[k - 2];
            }
            return findKth(A, B, al, ar, bl + 1, br, k - 1);
        }

        if ((m / 2 + n / 2) > k && A[al + m / 2 - 1] < B[bl + n / 2 - 1]) {
            return findKth(A, B, al, ar, bl, bl + n / 2, k);
        } else if ((m / 2 + n / 2) > k) {
            return findKth(A, B, al, al + m / 2, bl, br, k);
        } else if (A[al + m / 2 - 1] < B[bl + n / 2 - 1]) {

            return findKth(A, B, al + Math.max(m / 2, 1), ar, bl, br, k - Math.max(m / 2, 1));
        }

        return findKth(A, B, al, ar, bl + Math.max(n / 2, 1), br, k - Math.max(n / 2, 1));

    }

    public static void main(String[] args) {
        System.out.print(new MedianSortedArrays()
                .findMedianSortedArrays(new int[]{7}, new int[]{1, 2, 3, 4, 5, 6, 8}));
    }
}
