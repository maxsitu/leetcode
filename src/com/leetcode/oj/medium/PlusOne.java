package com.leetcode.oj.medium;

import java.util.Collections;
import java.util.List;

/**
 * Created by appleowner on 4/17/15.
 */
public class PlusOne {
    public List<Integer> plusOne(List<Integer> digits) {
        Collections.reverse(digits);
        boolean carry = false;
        for (int i = 0; i < digits.size(); i++) {
            int d = digits.get(i);
            if (d != 9) {
                digits.remove(i);
                digits.add(i, d + 1);
                carry = false;
                break;
            } else {
                digits.remove(i);
                digits.add(i, 0);
                carry = true;
            }
        }
        if (carry) digits.add(1);
        Collections.reverse(digits);
        return digits;
    }
}
