package com.leetcode.oj.medium;

import com.leetcode.oj.core.ListNode;
import com.leetcode.oj.core.TreeNode;

/**
 * Created by appleowner on 3/24/15.
 */
public class ConvertSortedListToBinarySearchTree {
    private ListNode node;

    public TreeNode sortedListToBST(ListNode head) {
        int step = count(head);
        node = new ListNode(0);
        node.next = head;
        return impl(step);
    }

    public TreeNode impl(int step) {
        if (step == 0) return null;
        TreeNode left = impl(step / 2);
        node = node.next;
        TreeNode curr = new TreeNode(node.val);
        TreeNode right = impl(step - step / 2 - 1);
        curr.left = left;
        curr.right = right;
        return curr;
    }

    public int count(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }
}
