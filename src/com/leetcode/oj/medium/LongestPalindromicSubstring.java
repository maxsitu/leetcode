package com.leetcode.oj.medium;

/**
 * Created by appleowner on 3/30/15.
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s.length() == 0) return "";
        char[] cArr = s.toCharArray();
        int startIndex = 0;
        int endIndex = -1;
        for (int i = 0; i < cArr.length; i++) {
            int len = endIndex - startIndex + 1;
            if (isPalindrome(cArr, i - len, i)) {
                startIndex = i - len;
                endIndex = i;
            } else if (i - len - 1 >= 0 && isPalindrome(cArr, i - len - 1, i)) {
                startIndex = i - len - 1;
                endIndex = i;
            }
        }
        return s.substring(startIndex, endIndex + 1);
    }

    public boolean isPalindrome(char[] cArr, int startIndex, int endIndex) {
        while (startIndex < endIndex) {
            if (cArr[startIndex] != cArr[endIndex]) return false;
            startIndex++;
            endIndex--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("a"));
    }
}
