package com.leetcode.oj.easy;

/**
 * Created by appleowner on 4/3/15.
 */
public class RemoveElement {
    public int removeElement(int[] A, int elem) {
        int eq = 0, neq = 0;
        while (eq < A.length && neq < A.length) {
            while (eq < A.length && A[eq] != elem) eq++;
            if (neq <= eq) neq = eq + 1;
            while (neq < A.length && A[neq] == elem) neq++;
            if (neq < A.length && eq < A.length) {
                A[eq] = A[neq];
                A[neq] = elem;
                eq++;
                neq++;
            }
        }
        return eq;
    }

    public static void main(String[] args) {
        System.out.println(new RemoveElement().removeElement(new int[]{2, 3}, 3));
    }
}
