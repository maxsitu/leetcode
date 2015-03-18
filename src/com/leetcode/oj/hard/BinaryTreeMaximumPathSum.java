package com.leetcode.oj.hard;

import com.leetcode.oj.core.TreeNode;

/**
 * Created by appleowner on 3/17/15.
 */
public class BinaryTreeMaximumPathSum {
    int maxValue = Integer.MIN_VALUE;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(-1);
        //root.right = new TreeNode(3);
        System.out.println(new BinaryTreeMaximumPathSum().maxPathSum(root));
    }

    public int maxPathSum(TreeNode root) {
        impl(root);
        return maxValue;
    }

    public int impl(TreeNode root) {
        if (root == null) return 0;
        int lval = Math.max(0, impl(root.left));
        int rval = Math.max(0, impl(root.right));
        maxValue = Math.max(maxValue, root.val + lval + rval);
        return Math.max(lval, rval) + root.val;
    }
}
