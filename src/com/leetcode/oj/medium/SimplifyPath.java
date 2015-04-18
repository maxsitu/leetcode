package com.leetcode.oj.medium;

import java.util.Collections;
import java.util.Stack;

/**
 * Created by appleowner on 4/18/15.
 */
public class SimplifyPath {
    public static void main(String[] args) {
        System.out.println(new SimplifyPath().simplifyPath("/home/..."));
    }

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] pathToken = path.split("/");
        for (String token : pathToken) {
            if (".".equals(token) || token.length() == 0) continue;
            else if ("..".equals(token)) {
                if (!stack.empty()) stack.pop();
            } else stack.push(token);
        }

        if (stack.empty()) return "/";

        Collections.reverse(stack);
        StringBuffer sb = new StringBuffer();
        while (!stack.empty()) {
            sb.append('/');
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
