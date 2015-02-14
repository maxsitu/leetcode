package com.leetcode.oj.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by appleowner on 1/22/15.
 */
public class GenParenthesis {
    public List<String> generateParenthesis(int n) {
        return generate(n, n, 0);
    }

    public List<String> generate(int start, int stop, int started) {
        List<String> ret = new ArrayList<String>();
        if (stop == 0 && started == 0) {
            return null;
        }
        if (start > 0) {
            List<String> sl = generate(start - 1, stop, started + 1);
            if (sl != null) {
                for (String s : sl) {
                    ret.add("(" + s);
                }
            } else {
                ret.add("(");
            }
        }
        if (stop > 0 && started > 0) {
            List<String> tl = generate(start, stop - 1, started - 1);
            if (tl != null) {
                for (String t : tl) {
                    ret.add(")" + t);
                }
            } else {
                ret.add(")");
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        new GenParenthesis().generateParenthesis(1);
    }
}
