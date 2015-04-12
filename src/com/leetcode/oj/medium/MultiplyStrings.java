package com.leetcode.oj.medium;

/**
 * Created by appleowner on 4/11/15.
 */
public class MultiplyStrings {
    public static void main(String[] args) {
        System.out.println(new MultiplyStrings().multiply("12345679", "63"));
    }

    public String multiply(String num1, String num2) {
        char[] cArr1 = num1.toCharArray();
        char[] cArr2 = num2.toCharArray();
        int[] product = new int[cArr1.length + cArr2.length];
        for (int i = cArr1.length - 1; i > -1; i--) {
            for (int j = cArr2.length - 1; j > -1; j--) {
                int index = i + j + 1;
                product[index] += (cArr1[i] - '0') * (cArr2[j] - '0');
                product[index - 1] += product[index] / 10;
                product[index] = product[index] % 10;

            }
        }
        StringBuffer sb = new StringBuffer();
        for (int k = 0; k < product.length - 1; k++) {
            if (sb.length() == 0 && product[k] == 0) continue;
            else sb.append(product[k]);
        }
        sb.append(product[product.length - 1]);
        return sb.toString();
    }
}
