package com.leetcode.oj.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by appleowner on 2/14/15.
 */
public class RestoreIpAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> ret = new ArrayList<String>();
        char[] cArr = s.toCharArray();
        if (cArr.length > 12 || cArr.length < 4) return ret;

        int left = 1;
        while (left < 4) {
            int right = cArr.length - 1;
            while (right > cArr.length - 4 && left + 1 < right) {
                int mid = left + 1;
                while (mid < right) {
                    if (isValid(Arrays.copyOfRange(cArr, 0, left)) &&
                            isValid(Arrays.copyOfRange(cArr, left, mid)) &&
                            isValid(Arrays.copyOfRange(cArr, mid, right)) &&
                            isValid(Arrays.copyOfRange(cArr, right, cArr.length))) {
                        ret.add(s.substring(0, left) + "." +
                                s.substring(left, mid) + "." +
                                s.substring(mid, right) + "." +
                                s.substring(right));
                    }
                    mid++;
                }
                right--;
            }
            left++;
        }
        return ret;
    }

    public boolean isValid(char[] s) {
        if (s.length > 3 || s.length <= 0) return false;
        if (s[0] == '0' && s.length > 1) return false;
        if (s.length < 3) return true;
        if (s[0] > '2') return false;
        if (s[0] == '2') {
            if (s[1] > '5') return false;
            else if (s[1] == '5' && s[2] > '5') return false;
        }
        return true;
    }

    public static void main(String[] args) {
        List<String> result = new RestoreIpAddresses().restoreIpAddresses("010010");
        for (String s : result) {
            System.out.format("\"%s\"  ", s);
        }
    }
}
