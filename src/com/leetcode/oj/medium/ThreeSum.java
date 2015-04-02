package com.leetcode.oj.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by appleowner on 4/1/15.
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++) {
            int lo = i + 1, hi = num.length - 1;
            while (lo < hi) {
                int val = num[i] + num[lo] + num[hi];
                if (val == 0) {
                    res.add(Arrays.asList(num[i], num[lo], num[hi]));
                    while (lo < hi && num[lo] == num[lo + 1]) lo++;
                    while (lo < hi && num[hi] == num[hi - 1]) hi--;
                    lo++;
                    hi--;
                } else if (val < 0) lo++;
                else hi--;
            }
            while (i < num.length - 2 && num[i] == num[i + 1]) i++;
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ThreeSum().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        for (List<Integer> l : list) {
            for (int n : l) {
                System.out.print(" " + n);
            }
            System.out.println();
        }
    }
}
