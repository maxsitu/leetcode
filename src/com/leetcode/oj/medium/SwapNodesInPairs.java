package com.leetcode.oj.medium;

import com.leetcode.oj.core.ListNode;

/**
 * Created by appleowner on 4/2/15.
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode third = null;
        while (first.next != null && first.next.next != null) {
            ListNode second = first.next;
            third = second.next.next;
            first.next = second.next;
            second.next.next = second;
            second.next = third;
            first = second;
        }
        return dummy.next;
    }
}
