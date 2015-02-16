package com.leetcode.oj.medium;

import com.leetcode.oj.core.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by appleowner on 2/15/15.
 */
public class BinaryTreeInOrderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (root != null || !stack.isEmpty()) {
            if (root == null) {
                root = stack.pop();
                ret.add(root.val);
                root = root.right;
            } else if (root.left != null) {
                stack.push(root);
                root = root.left;
            } else {
                ret.add(root.val);
                root = root.right;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(3).addToLeft(2).addToRight(1);
        List<Integer> l = new BinaryTreeInOrderTraversal().inorderTraversal(p);
        for (int n : l) {
            System.out.format("%d ", n);
        }
    }
}
