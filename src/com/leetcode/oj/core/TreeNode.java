package com.leetcode.oj.core;

/**
 * Created by appleowner on 2/14/15.
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public TreeNode addToRight(int pVal) {
        TreeNode parent = new TreeNode(pVal);
        parent.right = this;
        return parent;
    }

    public TreeNode addToLeft(int pVal) {
        TreeNode parent = new TreeNode(pVal);
        parent.left = this;
        return parent;
    }
}
