package com.leetcode.oj.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by appleowner on 4/11/15.
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        impl(candidates, 0, target, new ArrayList<Integer>(), ret);
        return ret;
    }

    public void impl(int[] candidates, int idx, int target, List<Integer> curr, List<List<Integer>> ret) {
        if (target == 0) {
            ret.add(curr);
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            int n = candidates[i];
            if (n <= target) {
                List<Integer> newCurr = new ArrayList<Integer>(curr);
                newCurr.add(n);
                impl(candidates, i, target - n, newCurr, ret);
            } else {
                return;
            }
        }
    }
}
