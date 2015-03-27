package com.leetcode.oj.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by appleowner on 3/26/15.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        char[] cArr = s.toCharArray();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int start = 0;
        for (int i = 0; i < cArr.length; i++) {
            if (map.containsKey(cArr[i])) {
                start = Math.max(start, map.get(cArr[i]) + 1);
                max = Math.max(i - start + 1, max);
            } else {
                max = Math.max(i - start + 1, max);
            }
            map.put(cArr[i], i);
        }
        return max;
    }
}
