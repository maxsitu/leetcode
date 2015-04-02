package com.leetcode.oj.easy;

import com.leetcode.oj.core.ListNode;

/**
 * Created by appleowner on 4/2/15.
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        while (fast != null && n > 0) {
            fast = fast.next;
            n--;
        }
        if (fast == null) return head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
