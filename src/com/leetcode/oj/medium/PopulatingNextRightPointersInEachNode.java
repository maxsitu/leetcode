package com.leetcode.oj.medium;

import com.leetcode.oj.core.TreeLinkNode;

/**
 * Created by appleowner on 3/22/15.
 */
public class PopulatingNextRightPointersInEachNode {
    public class Solution {
        public void connect(TreeLinkNode root) {
            if (root == null) return;
            TreeLinkNode pre = root;
            TreeLinkNode next = pre.left;
            while (next != null) {
                while (pre != null) {
                    pre.left.next = pre.right;
                    if (pre.next != null)
                        pre.right.next = pre.next.left;
                    pre = pre.next;
                }
                pre = next;
                next = pre.left;
            }
        }
    }
}
