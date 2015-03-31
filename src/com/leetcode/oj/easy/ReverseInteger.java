package com.leetcode.oj.easy;

/**
 * Created by appleowner on 3/30/15.
 */
public class ReverseInteger {
    public int reverse(int x) {
        int sign = 1;
        if (x < 0) sign = -1;
        long result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            x = x / 10;
        }
        if (result > Integer.MAX_VALUE ||
                result < Integer.MIN_VALUE) return 0;
        return (int) (result);
    }

    public static void main(String[] args) {
        System.out.println(new ReverseInteger().reverse(-123));
    }
}
