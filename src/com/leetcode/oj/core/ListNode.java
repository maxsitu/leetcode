package com.leetcode.oj.core;

/**
 * Created by appleowner on 2/8/15.
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public ListNode follow(int prev) {
        ListNode prevNode = new ListNode(prev);
        prevNode.next = this;
        return prevNode;
    }

    @Override
    public String toString() {
        return "" + this.val;
    }
}
