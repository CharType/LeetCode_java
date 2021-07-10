package com.cq.source.tree.leetcode;

import com.TreeNode.TreeNode;
import com.TreeNode.printer.BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/maximum-width-of-binary-tree/
 */
public class _662_二叉树最大宽度 {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int leveSize = 1;
        int value = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            leveSize--;
            if (node == null) continue;
            if (node.right != null || node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }

            if (leveSize == 0) {
                leveSize = queue.size();
                value = Math.max(leveSize, value);
            }
        }
        return value;
    }

    public static void main(String[] args) {
        _662_二叉树最大宽度 o = new _662_二叉树最大宽度();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.left.left = new TreeNode(6);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(9);
        root.right.right.right = new TreeNode(7);
        BinaryTrees.print(root);
        System.out.printf("\n");
        System.out.println(o.widthOfBinaryTree(root));
    }
}
