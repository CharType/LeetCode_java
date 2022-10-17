package com.arithmetic.cq.source.tree.leetcode;

import com.arithmetic.TreeNode.TreeNode;
import com.arithmetic.TreeNode.printer.BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

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

    public TreeNode invertTree1(TreeNode root) {
        if (root == null) return root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }
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
        System.out.println("翻转前：");
        BinaryTrees.print(root);
        TreeNode newTree = o.invertTree1(root);
        System.out.println('\n');
        System.out.println("翻转后：");
        BinaryTrees.print(newTree);
        System.out.println();
    }
}
