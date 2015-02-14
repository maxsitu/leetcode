package com.leetcode.oj.medium;

import com.leetcode.oj.core.ListNode;

/**
 * Created by appleowner on 2/8/15.
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode lefthead = null;
        ListNode lefttail = null;
        ListNode righthead = null;
        ListNode righttail = null;
        while (head != null) {
            if (head.val < x) {
                if (lefthead == null) {
                    lefthead = head;
                } else {
                    lefttail.next = head;
                }
                lefttail = head;
            } else {
                if (righthead == null) {
                    righthead = head;
                } else {
                    righttail.next = head;
                }
                righttail = head;
            }
            head = head.next;
        }
        if (lefttail != null) lefttail.next = righthead;
        if (righttail != null) righttail.next = null;
        return (lefthead == head) ? righthead : lefthead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ListNode node = new PartitionList().partition(head, 0);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
