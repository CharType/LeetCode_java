package com.cq.source.tree.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 */
public class _590_N叉树的后序遍历 {

    public List<Integer> postorderStack(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Deque<Node> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {

        }
        return list;
    }

    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        postorder(root, list);
        return list;
    }

    public void postorder(Node node, List<Integer> list) {
        if (node == null) return;
        for (int i = 0; i < node.children.size(); i++) {
            postorder(node.children.get(i), list);
        }
        list.add(node.val);
    }

    public static void main(String[] args) {

    }
}
