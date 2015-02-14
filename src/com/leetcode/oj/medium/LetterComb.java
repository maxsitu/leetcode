package com.leetcode.oj.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by appleowner on 1/22/15.
 */
public class LetterComb {
    public List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<String>();
        for (int i = 0; i < digits.length(); i++) {
            char c = digits.charAt(i);
            String chars = digit2Chars(c);
            if (chars == null) continue;
            int size = ret.size();
            if (size == 0) {
                for (int k = 0; k < chars.length(); k++) {
                    ret.add("" + chars.charAt(k));
                }
            }
            for (int j = 0; j < size; j++) {
                for (int k = 1; k < chars.length(); k++) {
                    ret.add(ret.get(j) + chars.charAt(k));
                }
            }
            for (int j = 0; j < size; j++) {
                ret.set(j, ret.get(j) + chars.charAt(0));
            }
        }
        if (ret.size() == 0) {
            ret.add("");
        }
        return ret;
    }

    public String digit2Chars(char d) {
        if (d == '2') {
            return "abc";
        } else if (d == '3') {
            return "def";
        } else if (d == '4') {
            return "ghi";
        } else if (d == '5') {
            return "jkl";
        } else if (d == '6') {
            return "mno";
        } else if (d == '7') {
            return "pqrs";
        } else if (d == '8') {
            return "tuv";
        } else if (d == '9') {
            return "wxyz";
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(new LetterComb().letterCombinations("2"));
    }
}
