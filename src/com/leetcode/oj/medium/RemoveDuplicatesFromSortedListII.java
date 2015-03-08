package com.leetcode.oj.medium;

import com.leetcode.oj.core.ListNode;

/**
 * Created by appleowner on 3/8/15.
 */
public class RemoveDuplicatesFromSortedListII {
    public static void main(String[] args) {
        ListNode head = new ListNode(5)
                .follow(4)
                .follow(4)
                .follow(3)
                .follow(3)
                .follow(2)
                .follow(1);

        ListNode trimmed = new RemoveDuplicatesFromSortedListII().deleteDuplicates(head);

        ListNode.traversePrint(trimmed);
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode last = dummy;
        boolean isGood = true;

        while (head != null) {
            if ((head.next == null || head.val != head.next.val) && isGood) {
                last.next = head;
                last = head;
            } else if (head.next != null && head.val == head.next.val) {
                isGood = false;
            } else {
                isGood = true;
            }
            head = head.next;
        }
        last.next = null;
        return dummy.next;
    }
}
