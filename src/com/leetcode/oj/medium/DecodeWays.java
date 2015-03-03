package com.leetcode.oj.medium;

/**
 * Created by appleowner on 2/25/15.
 */
public class DecodeWays {
    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        return impl(chars);
    }

    private int impl(char[] cArr) {
        int len = cArr.length;
        if (len == 0) return 0;

        int[] record = new int[len + 1];
        record[len] = 1;
        record[len - 1] = cArr[len - 1] == '0' ? 0 : 1;

        for (int i = len - 2; i >= 0; i--) {
            if (cArr[i] == '0') continue;
            else if (10 * (cArr[i] - '0') + cArr[i + 1] - '0' <= 26) {
                record[i] = record[i + 1] + record[i + 2];
            } else {
                record[i] = record[i + 1];
            }
        }
        return record[0];
    }

    public static void main(String[] args) {
        System.out.println(new DecodeWays().numDecodings("00"));
    }
}
