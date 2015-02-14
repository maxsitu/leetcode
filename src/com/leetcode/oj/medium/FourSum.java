package com.leetcode.oj.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by appleowner on 1/21/15.
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] num, int target) {
        Arrays.sort(num);
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for (int i = 0; i < num.length - 3; i++) {
            if (i != 0 && num[i] == num[i - 1])
                continue;
            for (int j = i + 1; j < num.length - 2; j++) {
                if (j != i + 1 && num[j] == num[j - 1])
                    continue;
                int p = j + 1;
                int q = num.length - 1;
                while (p < q) {
                    int sum = num[i] + num[j] + num[p] + num[q];
                    if (sum > target) {
                        q--;
                    } else if (sum < target) {
                        p++;
                    } else {
                        List<Integer> temp = new ArrayList<Integer>();
                        temp.add(num[i]);
                        temp.add(num[j]);
                        temp.add(num[p]);
                        temp.add(num[q]);
                        list.add(temp);
                        do {
                            p++;
                        } while (p < q && num[p] == num[p - 1]);
                        do {
                            q--;
                        } while (p < q && num[q] == num[q + 1]);
                    }
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, -2, -5, -4, -3, 3, 3, 5};
        int target = -11;
        System.out.println(new FourSum().fourSum(a, target));
    }
}
