package com.leetcode.oj.easy;

import com.leetcode.oj.core.ListNode;

/**
 * Created by v545192 on 4/2/2015.
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                curr = curr.next;
                l1 = l1.next;
            } else {
                curr.next = l2;
                curr = curr.next;
                l2 = l2.next;
            }
        }
        if (l1 != null) curr.next = l1;
        else if (l2 != null) curr.next = l2;
        return dummy.next;
    }
}
