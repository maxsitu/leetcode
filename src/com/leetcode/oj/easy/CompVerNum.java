package com.leetcode.oj.easy;


/**
 * Created by appleowner on 1/26/15.
 */
public class CompVerNum {
    public int compareVersion(String version1, String version2) {
        String[] va1 = version1.split("\\.");
        String[] va2 = version2.split("\\.");


        for (int i = 0; i < Math.max(va1.length, va2.length); i++) {
            int v1 = (i < va1.length) ? Integer.parseInt(va1[i]) : 0;
            int v2 = (i < va2.length) ? Integer.parseInt(va2[i]) : 0;
            if (v1 < v2) return -1;
            if (v1 > v2) return 1;
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new CompVerNum().compareVersion("1.0", "1"));
    }
}
