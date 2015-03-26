package com.leetcode.oj.medium;

import com.leetcode.oj.core.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by appleowner on 3/25/15.
 */
public class PathSumII {
    List<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return result;
        impl(root, new ArrayList<Integer>(), sum);
        return result;
    }

    public void impl(TreeNode node, List<Integer> record, int sum) {
        record.add(node.val);
        if (node.left == null && node.right == null && node.val == sum) {
            result.add(new ArrayList<Integer>(record));
        }

        if (node.left != null) impl(node.left, new ArrayList<Integer>(record), sum - node.val);
        if (node.right != null) impl(node.right, record, sum - node.val);
    }
}
