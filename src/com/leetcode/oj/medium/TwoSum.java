package com.leetcode.oj.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by appleowner on 3/25/15.
 */
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            int val = numbers[i];
            if (map.containsKey(val)) return new int[]{map.get(val) + 1, i + 1};
            map.put(target - val, i);
        }
        return new int[0];
    }
}
