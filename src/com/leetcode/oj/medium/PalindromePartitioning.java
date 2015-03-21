package com.leetcode.oj.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by appleowner on 3/21/15.
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        int length = s.length();
        List<List<String>>[] result = new List[length + 1];
        result[0] = new ArrayList<List<String>>();
        result[0].add(new ArrayList<String>());
        boolean[][] pair = new boolean[length][];

        for (int i = 0; i < s.length(); i++) {
            result[i + 1] = new ArrayList<List<String>>();
            pair[i] = new boolean[i];
            char c = s.charAt(i);
            for (int j = 0; j <= i; j++) {
                if (c != s.charAt(j)) {
                    continue;
                } else {
                    if (j == i || j == i - 1) pair[i][j] = true;
                    else pair[i][j] = pair[i - 1][j + 1];
                }

                if (pair[i][j]) {
                    String str = s.substring(j, i + 1);
                    for (List<String> jList : result[j]) {
                        List<String> l = new ArrayList<String>(jList);
                        l.add(str);
                        result[i + 1].add(l);
                    }
                }
            }
        }
        return result[length];
    }
}
