package com.arithmetic.TreeNode;

import com.arithmetic.TreeNode.printer.BinaryTreeInfo;

public class TreeNode implements BinaryTreeInfo {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public TreeNode() {
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public Object root() {
        return this;
    }

    @Override
    public Object left(Object node) {
        return ((TreeNode) node).left;
    }

    @Override
    public Object right(Object node) {
        return ((TreeNode) node).right;
    }

    @Override
    public Object string(Object node) {
        return ((TreeNode) node).val;
    }
}
