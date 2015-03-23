package com.leetcode.oj.medium;

import com.leetcode.oj.core.TreeNode;

import java.util.Stack;

/**
 * Created by v545192 on 3/23/2015.
 */
public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        TreeNode now = root;
        while (now != null) {
            if (now.left != null) {
                TreeNode pre = now.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = now.right;
                now.right = now.left;
                now.left = null;
            }

            now = now.right;
        }
    }

    public void flatten1(TreeNode root) {
        if (root == null) return;
        TreeNode now = root;
        Stack<TreeNode> rightNodes = new Stack<TreeNode>();
        while (now.left != null || now.right != null || !rightNodes.empty()) {
            if (now.left != null) {
                if (now.right != null) rightNodes.push(now.right);
                now.right = now.left;
                now.left = null;
                now = now.right;
            } else if (now.right != null) {
                now = now.right;
            } else {
                now.right = rightNodes.pop();
                now = now.right;
            }
        }
    }

}
