package com.leetcode.oj.medium;

import java.util.Arrays;

/**
 * Created by appleowner on 4/1/15.
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] num, int target) {
        int minDiff = Integer.MAX_VALUE;
        int ret = Integer.MAX_VALUE;
        int[] combo = {};
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++) {
            int lo = i + 1, hi = num.length - 1;
            while (lo < hi) {
                int val = num[i] + num[lo] + num[hi];
                int diff = Math.abs(val - target);
                if (diff < minDiff) {
                    combo = new int[]{num[i], num[lo], num[hi]};
                    minDiff = diff;
                    ret = val;
                }
                if (val == target) return ret;
                else if (val < target) {
                    while (lo < hi && num[lo] == num[lo + 1]) lo++;
                    lo++;
                } else {
                    while (lo < hi && num[hi] == num[hi - 1]) hi--;
                    hi--;
                }
            }
            while (i < num.length - 2 && num[i] == num[i + 1]) i++;
        }
        for (int n : combo) {
            System.out.print(" " + n);
        }
        System.out.println();
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new ThreeSumClosest()
                .threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }
}
