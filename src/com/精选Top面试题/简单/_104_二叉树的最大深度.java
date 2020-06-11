package com.精选Top面试题.简单;

import com.TreeNode.TreeNode;

/**
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 */
public class _104_二叉树的最大深度 {
    // TODO:迭代待实现
    public int maxDepth1(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;



        return 1;
    }
    // 递归
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        _104_二叉树的最大深度 o = new _104_二叉树的最大深度();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(o.maxDepth(root));
    }
}
