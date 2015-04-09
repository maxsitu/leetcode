package com.leetcode.oj.hard;

import java.util.Stack;

/**
 * Created by appleowner on 4/8/15.
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        char[] cArr = s.toCharArray();
        Stack<Integer> st = new Stack<Integer>();
        st.push(-1);
        int n = cArr.length;
        for (int i = 0; i < n; i++) {
            if (cArr[i] == ')' &&
                    !st.empty() &&
                    st.peek() != -1 &&
                    cArr[st.peek()] == '(') {
                st.pop();
            } else {
                st.push(i);
            }
        }
        int longest = 0;
        int end = n;
        while (!st.empty()) {
            longest = Math.max(longest, end - st.peek() - 1);
            end = st.pop();
        }
        return longest;
    }


}
