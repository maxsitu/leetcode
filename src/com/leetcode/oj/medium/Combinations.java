package com.leetcode.oj.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by appleowner on 4/20/15.
 */
public class Combinations {
    public static void main(String[] args) {
        List<List<Integer>> l = new Combinations().combine(2, 2);
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> l = new ArrayList<>();
        if (n < 1 || k < 1 || n < k) return l;
        List<List<Integer>> sL1 = combine(n - 1, k - 1);
        if (sL1.size() == 0) l.add(new ArrayList<Integer>(Arrays.asList(n)));
        else {
            for (int i = 0; i < sL1.size(); i++) {
                List<Integer> el = sL1.get(i);
                el.add(n);
                l.add(el);
            }
        }
        l.addAll(combine(n - 1, k));
        return l;
    }
}
