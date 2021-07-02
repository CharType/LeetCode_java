package com.cq.source.search.tree.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
 */
public class _589_N叉树的前序遍历 {
    // 迭代方式
    public List<Integer> preorderStack(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            list.add(node.val);
            for (int i = node.children.size() - 1; i >= 0; i--) {
                stack.add(node.children.get(i));
            }
        }
        return list;
    }

    // 递归方式
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        preorder(root, list);
        return list;
    }

    public void preorder(Node node, List<Integer> list) {
        if (node == null) return;
        list.add(node.val);
        if (node.children == null || node.children.size() == 0) return;
        for (int i = 0; i < node.children.size(); i++) {
            preorder(node.children.get(i), list);
        }
    }

    public static void main(String[] args) {
        _589_N叉树的前序遍历 o = new _589_N叉树的前序遍历();
        Node root = new Node(1, null);
        List<Node> children = new ArrayList<>();
//        for (int i = 0;i < 5;i++) {
//            children[]
//        }
        System.out.println(o.preorder(root));
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
