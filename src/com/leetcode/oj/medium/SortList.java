package com.leetcode.oj.medium;

import com.leetcode.oj.core.ListNode;

/**
 * Created by appleowner on 2/13/15.
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode right = sortList(slow.next);
        slow.next = null;
        ListNode left = sortList(head);

        head = new ListNode(-1);
        ListNode tail = head;
        while (left != null && right != null) {
            if (left.val < right.val) {
                tail.next = left;
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }

        if (left != null) tail.next = left;
        if (right != null) tail.next = right;
        return head.next;
    }

    public static void main(String[] args) {
        new SortList().sortList(new ListNode(1));
    }
}
