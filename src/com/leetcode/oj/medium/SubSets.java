package com.leetcode.oj.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by appleowner on 2/7/15.
 */
public class SubSets {
    public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(S);
        for (int i = 0; i <= S.length; i++) {
            result.addAll(compo(0, S, i));
        }
        return result;
    }

    public List<List<Integer>> compo(int start, int[] S, int k) {
        if (k == 0) {
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            result.add(new ArrayList<Integer>());
            return result;
        }
        if (k == 1) {
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            for (int i = start; i < S.length; i++) {
                List<Integer> l = new ArrayList<Integer>();
                l.add(S[i]);
                result.add(l);
            }
            return result;
        }

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = start; i <= S.length - k; i++) {
            List<List<Integer>> l = compo(i + 1, S, k - 1);
            for (List<Integer> row : l) {
                row.add(0, S[i]);
            }
            result.addAll(l);
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = new SubSets().subsets(new int[]{1, 2, 3});
        for (List<Integer> l : result) {
            for (int i : l) {
                System.out.format("%2d ", i);
            }
            System.out.println();
        }
    }
}
