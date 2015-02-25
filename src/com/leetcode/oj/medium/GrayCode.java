package com.leetcode.oj.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by appleowner on 2/24/15.
 */
public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>();
        result.add(0);
        for (int i = 0; i < n; i++) {
            int inc = 1 << i;
            for (int j = result.size() - 1; j >= 0; j--) {
                result.add(result.get(j) | inc);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> result = new GrayCode().grayCode(3);
        for (int n : result) {
            System.out.format("%d ", n);
        }
    }
}
