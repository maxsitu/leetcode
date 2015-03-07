package com.leetcode.oj.core;

import java.util.Stack;

/**
 * Created by appleowner on 2/14/15.
 * Make this change to test the link to agilezen
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

    public static String preOrder(TreeNode p) {
        StringBuffer sb = new StringBuffer();
        Stack<TreeNode> pStack = new Stack<TreeNode>();
        while (p != null) {
            pStack.add(p);
            p = p.left;
        }
        while (p != null || !pStack.isEmpty()) {
            if (p == null) {
                p = pStack.pop();
            } else {
                sb.append(p.val + " ");
                p = p.right;
                if (p != null) sb.append("# ");
                while (p != null) {
                    pStack.add(p);
                    p = p.left;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        TreeNode p = n4;
        p.left = n2;
        p.right = n5;
        n2.left = n1;
        n2.right = n3;
        System.out.println(TreeNode.preOrder(p));
    }
}
