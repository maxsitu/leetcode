package com.leetcode.oj.easy;

/**
 * Created by appleowner on 1/4/15.
 */
public class ValidPalindrome {
    public static void main(String[] args) throws java.lang.Exception {
        // your code goes here
        boolean result = new ValidPalindrome().isPalindrome(args[0]);
        System.out.println(result);
    }

    public boolean isPalindrome(String s) {
        int i = 0;
        int bi = s.length() - 1;
        while (i < bi) {
            char c = s.charAt(i);
            if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9'))) {
                i = i + 1;
                continue;
            }
            char bc = s.charAt(bi);
            if (!((bc >= 'a' && c <= 'z') || (bc >= 'A' && bc <= 'Z') || (bc >= '0' && bc <= '9'))) {
                bi = bi - 1;
                continue;
            }
            c = Character.toLowerCase(c);
            bc = Character.toLowerCase(bc);
            if (c != bc) {
                System.out.println(c);
                System.out.println(bc);
                System.out.println("i=" + i);
                System.out.println("bi=" + bi);
                return false;
            }
            i = i + 1;
            bi = bi - 1;
        }
        return true;
    }
}
