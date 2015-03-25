package com.leetcode.oj.medium;

import com.leetcode.oj.core.TreeNode;

/**
 * Created by appleowner on 3/11/15.
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        TreeNode root = new ConstructBinaryTreeFromInorderAndPostorderTraversal().buildTree(new int[]{1, 2}, new int[]{2, 1});
        System.out.println(TreeNode.preOrder(root));
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return impl(inorder, postorder, 0, inorder.length - 1, postorder.length - 1);
    }

    public TreeNode impl(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart) {
        if (postStart < 0 || inStart > inEnd) return null;
        TreeNode root = new TreeNode(postorder[postStart]);
        int inIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
                break;
            }
        }// left: inIndex; right: inorder.length-inIndex-1
        root.left = impl(inorder, postorder, inStart, inIndex - 1, postStart + inIndex - inorder.length);
        root.right = impl(inorder, postorder, inIndex + 1, inEnd, postStart - 1);
        return root;
    }
}
