package com.leetcode.oj.easy;

import java.util.Stack;

/**
 * Created by appleowner on 4/2/15.
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (stack.empty()) return false;
            else {
                char last = stack.pop();
                if (!(last == '(' && c == ')' ||
                        last == '{' && c == '}' ||
                        last == '[' && c == ']'))
                    return false;
            }
        }
        return stack.empty();
    }
}
