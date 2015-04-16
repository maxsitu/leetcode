package com.leetcode.oj.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by appleowner on 4/15/15.
 */
public class PermutationSequence {
    public String getPermutation(int n, int k) {
        int[] fact = new int[n];
        fact[0] = 1;
        for (int i = 1; i < fact.length; i++) {
            fact[i] = fact[i - 1] * i;
        }
        List<Integer> l = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) l.add(i);
        StringBuffer sb = new StringBuffer();
        k = k - 1;
        for (int i = n - 1; i >= 0; i--) {
            int idx = k / fact[i];
            k = k % fact[i];
            sb.append(l.get(idx));
            l.remove(idx);
        }
        return sb.toString();
    }
}
