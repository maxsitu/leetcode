package com.leetcode.oj.medium;


import com.leetcode.oj.core.ListNode;

public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return head;

        ListNode curr = head;
        head = new ListNode(-1);
        head.next = curr;
        ListNode prev = head, start = head.next;
        curr = start.next;
        start.next = null;

        while (curr != null) {
            while (start != null) {
                if (start.next == null) {
                    start.next = curr;
                    curr = curr.next;
                    start.next.next = null;
                    break;
                } else {
                    if (start.val > curr.val) {
                        prev.next = curr;
                        curr = curr.next;
                        prev.next.next = start;
                        break;
                    }
                    prev = start;
                    start = start.next;
                }
            }
            prev = head;
            start = head.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        new InsertionSortList().insertionSortList(head);

        while (head != null) {
            System.out.format("%3d", head.val);
            head = head.next;
        }
    }
}
