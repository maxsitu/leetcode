package com.leetcode.oj.core;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by appleowner on 2/15/15.
 */
public class UndirectedGraphNode {
    public int label;
    public List<UndirectedGraphNode> neighbors;

    public UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}
