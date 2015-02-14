package com.leetcode.oj.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by appleowner on 1/31/15.
 */
public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        Arrays.sort(num);

        List<List<Integer>> list = new ArrayList<List<Integer>>();
        implement(list, num, 0, target);
        return list;
    }

    public void implement(List<List<Integer>> ret, int[] num, int start, int target) {
        int i = start;
        while (i < num.length) {
            if (num[i] > target) return;
            else if (num[i] == target) {
                List<Integer> list = new ArrayList<Integer>();
                list.add(num[i]);
                ret.add(list);
                return;
            } else {
                List<List<Integer>> list = new ArrayList<List<Integer>>();
                implement(list, num, i + 1, target - num[i]);
                for (List<Integer> l : list) {
                    l.add(0, num[i]);
                    ret.add(l);
                }
            }

            do {
                i++;
            }
            while (i < num.length && num[i] == num[i - 1]);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new CombinationSum2().combinationSum2(new int[]{1, 2}, 4);
        System.out.println(list);
    }
}
