package com.leetcode.oj.easy;

/**
 * Created by WallE on 2015/3/31.
 */
public class StringToInteger {
    public static void main(String[] args) {
        System.out.println(new StringToInteger().atoi("  -34567"));
    }

    public int atoi(String str) {
        char[] cArr = str.toCharArray();
        int idx = 0;
        boolean positive = true;
        long result = 0;
        if (cArr.length == 0) return 0;
        while (cArr[idx] == ' ') idx++;
        if (cArr[idx] == '+') idx++;
        else if (cArr[idx] == '-') {
            positive = false;
            idx++;
        }
        while (idx < cArr.length && cArr[idx] >= '0' && cArr[idx] <= '9') {
            if (positive) {
                result = result * 10 + cArr[idx] - '0';
                if (result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            } else {
                result = result * 10 - cArr[idx] + '0';
                if (result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            }
            idx++;
        }
        return (int) result;
    }
}
