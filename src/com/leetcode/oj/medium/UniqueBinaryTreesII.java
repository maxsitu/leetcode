package com.leetcode.oj.medium;

import com.leetcode.oj.core.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by appleowner on 3/2/15.
 */
public class UniqueBinaryTreesII {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode>[] memo = new List[n + 1];
        memo[0] = new ArrayList<TreeNode>();
        memo[0].add(null);

        for (int i = 1; i <= n; i++) {
            memo[i] = new ArrayList<TreeNode>();

            for (int j = 0; j < i; j++) {

                List<TreeNode> lnodes = memo[j];
                List<TreeNode> rnodes = memo[i - 1 - j];
                for (TreeNode l : lnodes) {
                    for (TreeNode r : rnodes) {
                        TreeNode p = new TreeNode(j + 1);
                        p.left = l;
                        p.right = clone(r, j + 1);
                        memo[i].add(p);
                    }
                }
            }
        }
        return memo[n];
    }

    private TreeNode clone(TreeNode node, int inc) {
        if (node != null) {
            TreeNode p = new TreeNode(node.val + inc);
            p.left = clone(node.left, inc);
            p.right = clone(node.right, inc);
            return p;
        } else return null;
    }

    public static void main(String[] args) {
        List<TreeNode> pl = new UniqueBinaryTreesII().generateTrees(3);
        for (TreeNode p : pl) {
            System.out.println(TreeNode.preOrder(p));
        }
    }
}
