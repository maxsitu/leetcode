package com.leetcode.oj.medium;

import com.leetcode.oj.core.ListNode;

/**
 * Created by appleowner on 2/14/15.
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode subListHead = new ListNode(-1);
        ListNode subListTail = subListHead;
        ListNode curr = head, prev = dummyHead;
        while (curr != null && n > 0) {
            m--;
            n--;
            ListNode temp = curr.next;
            if (m > 0) prev = curr;
            else if (m == 0) {
                subListHead.next = curr;
                subListTail = curr;
            } else {
                curr.next = subListHead.next;
                subListHead.next = curr;
            }
            curr = temp;
        }

        prev.next = subListHead.next;
        subListTail.next = curr;
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(5)
                .follow(3);

        head = new ReverseLinkedListII().reverseBetween(head, 2, 2);

        while (head != null) {
            System.out.format("%d->", head.val);
            head = head.next;
        }
        System.out.println(head);
    }
}
