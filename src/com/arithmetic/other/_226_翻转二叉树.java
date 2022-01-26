package com.arithmetic.other;

import com.arithmetic.TreeNode.TreeNode;

/**
 * https://leetcode-cn.com/problems/invert-binary-tree/
 */
public class _226_翻转二叉树 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode leftNode = root.left;
        root.left = root.right;
        root.right = leftNode;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        _226_翻转二叉树 o = new _226_翻转二叉树();
        TreeNode newTree =  o.invertTree(root);
        System.out.println();
    }
}
