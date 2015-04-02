package com.leetcode.oj.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by appleowner on 4/1/15.
 */
public class LetterCombinationsOfAPhoneNumber {
    static Map<Character, String> keyMap;

    static {
        keyMap = new HashMap<Character, String>();
        keyMap.put('1', "");
        keyMap.put('2', "abc");
        keyMap.put('3', "def");
        keyMap.put('4', "ghi");
        keyMap.put('5', "jkl");
        keyMap.put('6', "mno");
        keyMap.put('7', "pqrs");
        keyMap.put('8', "tuv");
        keyMap.put('9', "wxyz");
        keyMap.put('0', " ");
    }

    public List<String> letterCombinations(String digits) {
        List<StringBuffer> sbl = new ArrayList<StringBuffer>();
        for (char c : digits.toCharArray()) {
            if (keyMap.containsKey(c)) {
                String s = keyMap.get(c);
                sbl = helper(sbl, s);
            }
        }
        List<String> list = new ArrayList<String>();
        for (StringBuffer sb : sbl) {
            list.add(sb.toString());
        }
        return list;
    }

    public List<StringBuffer> helper(List<StringBuffer> sbl, String str) {
        List<StringBuffer> res = new ArrayList<StringBuffer>();
        if (sbl.size() == 0) {
            for (char c : str.toCharArray()) {
                StringBuffer sb = new StringBuffer();
                sb.append(c);
                res.add(sb);
            }
        } else {
            for (StringBuffer sb : sbl) {
                for (char c : str.toCharArray()) {
                    StringBuffer nsb = new StringBuffer(sb.toString());
                    nsb.append(c);
                    res.add(nsb);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> list = new LetterCombinationsOfAPhoneNumber().letterCombinations("23");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i != list.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}
