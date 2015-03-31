package com.leetcode.oj.easy;

/**
 * Created by appleowner on 3/30/15.
 */
public class ZigZagConversion {
    public String convert(String s, int nRows) {
        if (nRows == 1) return s;
        char[] cArr = s.toCharArray();
        StringBuffer result = new StringBuffer();
        int period = 2 * nRows - 2;
        for (int i = 0; i < nRows; i++) {
            int idxA = i;
            int idxB = (period - idxA) % period;
            if (idxA == idxB) {
                int j = idxA;
                while (j < cArr.length) {
                    result.append(cArr[j]);
                    j = j + period;
                }
            } else {
                int j = idxA;
                int k = idxB;
                while (j < cArr.length) {
                    result.append(cArr[j]);
                    if (k < cArr.length)
                        result.append(cArr[k]);
                    j = j + period;
                    k = k + period;
                }
            }
        }
        return result.toString();
    }
}
