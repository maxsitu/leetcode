package com.leetcode.oj.medium;

import com.leetcode.oj.core.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by appleowner on 3/8/15.
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(3);
        p.left = new TreeNode(9);
        p.right = new TreeNode(20);
        p.right.left = new TreeNode(15);
        p.right.right = new TreeNode(7);

        List<List<Integer>> list = new BinaryTreeZigzagLevelOrderTraversal().zigzagLevelOrder(p);

        System.out.println('[');
        for (List<Integer> l : list) {
            System.out.print("\t[");
            for (int n : l) {
                System.out.print(n);
                System.out.print(", ");
            }
            System.out.println("]");
        }
        System.out.println(']');
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        impl(root, result, 0);
        return result;
    }

    public void impl(TreeNode node, List<List<Integer>> list, int level) {
        if (node == null) return;
        if (list.size() < level + 1) {
            list.add(new ArrayList<Integer>());
        }
        if (level % 2 == 0) {
            list.get(level).add(node.val);
        } else {
            list.get(level).add(0, node.val);
        }

        impl(node.left, list, level + 1);
        impl(node.right, list, level + 1);
    }
}
