package com.cq.source.search.tree.leetcode;

/**
 * https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/
 */
public class _559_N叉树的最大深度 {
    public int maxDepth(Node root) {
        if (root == null) return 0;

        return maxDepth(root, 1);
    }

    public int maxDepth(Node node, int parentDepth) {
        if (node == null) return parentDepth;
        int depth = 0;
        for (int i = 0; i < node.children.size(); i++) {
            depth = Math.max(maxDepth(node.children.get(i), parentDepth + 1), depth);
        }
        return depth + 1;
    }

    public static void main(String[] args) {

    }
}
