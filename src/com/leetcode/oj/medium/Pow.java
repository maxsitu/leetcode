package com.leetcode.oj.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by appleowner on 2/2/15.
 */
public class Pow {
    public double pow(double x, int n) {
        if (n == 0) return 1;
        boolean isNeg = (n < 0);
        n = Math.abs(n);
        List<Integer> l = new ArrayList<Integer>();
        while (n != 0) {
            if (n % 2 == 0) {
                l.add(0);
            } else {
                l.add(1);
            }
            n /= 2;
        }
        double result = 1;
        for (int i : l) {
            if (i == 1) {
                result *= x;
            }
            x *= x;
        }
        if (isNeg) result = (double) 1.0 / result;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Pow().pow(8.88023, 3));
    }
}
