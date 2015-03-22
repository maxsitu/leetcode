package com.leetcode.oj.medium;

import com.leetcode.oj.core.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by appleowner on 3/22/15.
 */
public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        int sum = 0;
        if (root == null) return 0;
        List<TreeNode> parents = new ArrayList<TreeNode>();
        parents.add(root);
        while (!parents.isEmpty()) {
            List<TreeNode> newParents = new ArrayList<TreeNode>();
            for (TreeNode node : parents) {
                if (node.left == null && node.right == null) {
                    sum += node.val;
                    continue;
                }
                if (node.left != null) {
                    node.left.val += node.val * 10;
                    newParents.add(node.left);
                }
                if (node.right != null) {
                    node.right.val += node.val * 10;
                    newParents.add(node.right);
                }
            }
            parents = newParents;
        }
        return sum;
    }
}
