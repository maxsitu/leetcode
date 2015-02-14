package com.leetcode.oj.medium;

/**
 * Created by appleowner on 1/24/15.
 */
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        int sign = 1;
        int result = 0;

        long divisorl = (long) divisor;
        long dividendl = (long) dividend;
        if (dividendl < 0) {
            sign = -1;
            dividendl = -dividendl;
        }

        if (divisorl < 0) {
            sign = -sign;
            divisorl = -divisorl;
        }

        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }

        if (dividendl < divisorl) {
            return 0;
        }

        int base = 1;

        while ((divisorl) < dividendl) {
            base <<= 1;
            divisorl <<= 1;
        }

        while (base > 0) {
            if (dividendl >= divisorl) {
                dividendl -= divisorl;
                result += base;
            }
            divisorl >>= 1;
            base >>= 1;
        }
        return result * sign;
    }

    public static void main(String[] args) {
        System.out.println(new DivideTwoIntegers().divide(-1, 1));
    }
}
