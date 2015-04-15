package com.leetcode.oj.medium;

import java.util.*;

/**
 * Created by appleowner on 4/14/15.
 */
public class Anagrams {
    public List<String> anagrams(String[] strs) {
        Map<String, List<String>> anaGroup = new HashMap<String, List<String>>();
        for (String str : strs) {
            String sig = getSignature(str);
            if (!anaGroup.containsKey(sig)) {
                anaGroup.put(sig, new ArrayList<String>());
            }
            anaGroup.get(sig).add(str);
        }
        List<String> res = new ArrayList<String>();
        for (List<String> list : anaGroup.values()) {
            if (list.size() > 1) {
                res.addAll(list);
            }
        }
        return res;
    }

    public String getSignature(String str) {
        char[] ca = str.toCharArray();
        Arrays.sort(ca);
        return new String(ca);
    }
}
