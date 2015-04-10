package com.leetcode.oj.medium;

/**
 * Created by appleowner on 4/6/15.
 */
public class NextPermutation {

    public static void main(String[] args) {
        int[] num = new int[]{1, 1, 5};
        new NextPermutation().nextPermutation(num);
        for (int n : num) {
            System.out.print(" " + n);
        }
    }

    public void nextPermutation(int[] num) {
        if (num.length < 2) return;
        int idx = num.length - 1;
        while (idx > 0 && num[idx - 1] >= num[idx]) idx--;
        if (idx == 0) {
            reverse(num, 0, num.length - 1);
            return;
        }
        idx--;
        int jdx = num.length - 1;
        while (num[jdx] <= num[idx]) jdx--;
        swap(num, idx, jdx);
        reverse(num, idx + 1, num.length - 1);
    }

    public void swap(int[] num, int i, int j) {
        num[i] ^= num[j];
        num[j] ^= num[i];
        num[i] ^= num[j];
    }

    public void reverse(int[] num, int start, int end) {
        int i = start;
        int j = end;
        while (i < j) {
            swap(num, i++, j--);
        }
    }
}
