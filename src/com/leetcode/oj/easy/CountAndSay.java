package com.leetcode.oj.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by appleowner on 4/10/15.
 */
public class CountAndSay {
    public String countAndSay(int n) {
        List<Integer> result = Arrays.asList(1);
        while (n-- > 1) {
            result = impl(result);
        }
        StringBuffer sb = new StringBuffer();
        for (Integer num : result) {
            sb.append(num);
        }
        return sb.toString();
    }

    public List<Integer> impl(List<Integer> list) {
        int curr = list.get(0);
        int count = 0;
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < list.size(); i++) {
            int n = list.get(i);
            if (curr == n) {
                count++;
            } else {
                res.add(count);
                res.add(curr);
                curr = n;
                count = 1;
            }
        }
        res.add(count);
        res.add(curr);
        return res;
    }
}
