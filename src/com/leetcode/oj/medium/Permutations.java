package com.leetcode.oj.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by appleowner on 4/11/15.
 */
public class Permutations {
    public static void main(String[] args) {
        List<List<Integer>> list = new Permutations().permute(new int[]{1, 2, 3, 4});
        for (List<Integer> l : list) {
            for (int n : l) {
                System.out.print(" " + n);
            }
            System.out.println();
        }
    }

    public List<List<Integer>> permute(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        impl(num, 0, new ArrayList<List<Integer>>(), ret);
        return ret;
    }

    public void impl(int[] num, int idx, List<List<Integer>> curr, List<List<Integer>> ret) {
        if (idx >= num.length) {
            ret.addAll(curr);
            return;
        }
        List<List<Integer>> newCurr = new ArrayList<List<Integer>>();
        if (curr.isEmpty()) {
            List<Integer> list = Arrays.asList(num[idx]);
            newCurr.add(list);
        } else {
            int n = num[idx];
            for (List<Integer> list : curr) {
                for (int i = 0; i < list.size(); i++) {

                    if (n == list.get(i)) continue;
                    else {
                        List<Integer> l = new ArrayList<Integer>(list);
                        l.add(i, n);
                        newCurr.add(l);
                    }
                }
                List<Integer> l = new ArrayList<Integer>(list);
                l.add(l.size(), n);
                newCurr.add(l);
            }
        }
        impl(num, idx + 1, newCurr, ret);
    }
}
