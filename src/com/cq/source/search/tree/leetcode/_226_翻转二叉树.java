package com.cq.source.search.tree.leetcode;

import com.TreeNode.TreeNode;
import com.TreeNode.printer.BinaryTrees;

/**
 * https://leetcode-cn.com/problems/invert-binary-tree/
 */
public class _226_翻转二叉树 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;
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
        com.other._226_翻转二叉树 o = new com.other._226_翻转二叉树();
        System.out.println("翻转前：");
        BinaryTrees.print(root);
        TreeNode newTree = o.invertTree(root);
        System.out.println('\n');
        System.out.println("翻转后：");
        BinaryTrees.print(newTree);
        System.out.println();
    }
}
