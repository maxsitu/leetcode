package com.leetcode.oj.medium;

/**
 * Created by appleowner on 4/18/15.
 */
public class Sqrtx {
    public static void main(String[] args) {
        System.out.println(Math.sqrt(2147395599));
        System.out.println(new Sqrtx().mySqrt(2147395599));

    }

    public int mySqrt(int x) {
        if (x == 0) return 0;
        int sm = 1;
        int lg = x;
        int mid = (sm + lg) / 2;
        while (sm <= lg) {
            long product = x / mid;
            if (product == mid) break;
            else if (product < mid) {
                lg = mid - 1;
            } else sm = mid + 1;
            mid = (sm + lg) / 2;
        }
        return mid;
    }
}
