package com.leetcode.oj.medium;

import com.leetcode.oj.core.UndirectedGraphNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by appleowner on 2/15/15.
 */
public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        return cloneGraph(map, node);
    }

    public UndirectedGraphNode cloneGraph(Map<UndirectedGraphNode, UndirectedGraphNode> map, UndirectedGraphNode node) {
        UndirectedGraphNode newNode = map.get(node);
        if (newNode == null) {
            newNode = new UndirectedGraphNode(node.label);
            map.put(node, newNode);
        } else {
            return newNode;
        }
        for (UndirectedGraphNode n : node.neighbors) {
            newNode.neighbors.add(cloneGraph(map, n));
        }
        return newNode;
    }
}
