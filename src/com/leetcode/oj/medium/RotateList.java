package com.leetcode.oj.medium;

import com.leetcode.oj.core.ListNode;

/**
 * Created by appleowner on 3/8/15.
 */
public class RotateList {
    public static void main(String[] args) {
        ListNode head = new ListNode(5).follow(4).follow(3).follow(2).follow(1);
        head = new RotateList().rotateRight(head, 0);

        System.out.print(head.val);
        while (head != null) {
            System.out.print("->" + head.next);
            head = head.next;
        }
    }

    public ListNode rotateRight(ListNode head, int n) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;

        int i;
        for (i = 0; fast.next != null; i++)//Get the total length
            fast = fast.next;

        for (int j = i - n % i; j > 0; j--) //Get the i-n%i th node
            slow = slow.next;

        fast.next = dummy.next; //Do the rotation
        dummy.next = slow.next;
        slow.next = null;

        return dummy.next;
    }
}
