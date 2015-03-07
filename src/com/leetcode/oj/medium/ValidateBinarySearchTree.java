package com.leetcode.oj.medium;

import com.leetcode.oj.core.TreeNode;

/**
 * Created by appleowner on 3/7/15.
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return impl(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean impl(TreeNode p, long min, long max) {
        if (p == null) return true;
        if (p.val <= min || p.val >= max) return false;
        return impl(p.left, min, p.val) && impl(p.right, p.val, max);
    }
}
