package com.leetcode.oj.medium;

import com.leetcode.oj.core.TreeNode;

/**
 * Created by appleowner on 3/9/15.
 */
public class ConstructBinaryTreeFromPreoderAndInorderTraversal {
    public static void main(String[] args) {
        new ConstructBinaryTreeFromPreoderAndInorderTraversal().buildTree(new int[]{1, 2}, new int[]{1, 2});
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return impl(preorder, 0, inorder, 0, inorder.length - 1);
    }

    public TreeNode impl(int[] preorder, int preStart, int[] inorder, int inStart, int inEnd) {
        if (preStart >= preorder.length || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndx = 0;

        for (int i = inStart; i <= inEnd; i++) {
            if (root.val == inorder[i]) {
                inIndx = i;
                break;
            }
        }
        root.left = impl(preorder, preStart + 1, inorder, inStart, inIndx - 1);
        root.right = impl(preorder, preStart + inIndx - inStart + 1, inorder, inIndx + 1, inEnd);
        return root;
    }
}
