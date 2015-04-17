package com.leetcode.oj.medium;

/**
 * Created by appleowner on 4/17/15.
 */
public class AddBinary {
    public static void main(String[] args) {
        System.out.println(new AddBinary().addBinary("1010", "1011"));
    }

    public String addBinary(String a, String b) {
        char[] aA = a.toCharArray();
        char[] bA = b.toCharArray();
        reverse(aA);
        reverse(bA);
        int carry = 0;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < aA.length || i < bA.length; i++) {
            int nA = (i < aA.length) ? aA[i] - '0' : 0;
            int nB = (i < bA.length) ? bA[i] - '0' : 0;
            int sum = nA + nB + carry;
            int n = sum % 2;
            carry = sum / 2;
            sb.append(n);
        }
        while (carry > 0) {
            sb.append(carry % 2);
            carry = carry / 2;
        }
        return sb.reverse().toString();
    }

    public void reverse(char[] arr) {
        int begin = 0, end = arr.length - 1;
        while (begin < end) {
            char tmp = arr[begin];
            arr[begin] = arr[end];
            arr[end] = tmp;
            begin++;
            end--;
        }
    }
}
