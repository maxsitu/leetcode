package com.leetcode.oj.medium;

import com.leetcode.oj.core.TreeNode;

/**
 * Created by appleowner on 3/24/15.
 */
public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] num) {
        if (num.length == 0) return null;
        return impl(num, 0, num.length - 1);
    }

    public TreeNode impl(int[] num, int left, int right) {
        if (left > right) return null;
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = impl(num, left, mid - 1);
        root.right = impl(num, mid + 1, right);
        return root;
    }
}
