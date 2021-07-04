package com.cq.source.search.tree.leetcode;

import com.TreeNode.TreeNode;
import com.TreeNode.printer.BinaryTrees;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 */
public class _114_二叉树展开为链表 {
    public void flatten(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        TreeNode newNode = new TreeNode();
        TreeNode tempNode = newNode;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            newNode.right = node;
            newNode = newNode.right;
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
        root.right = tempNode.right.right;
        TreeNode node = root;
        while (node != null) {
            node.left = null;
            node = node.right;
        }
    }

    public static void main(String[] args) {
        _114_二叉树展开为链表 o = new _114_二叉树展开为链表();
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(4);
        node.right = new TreeNode(5);
        node.right.right = new TreeNode(6);
        BinaryTrees.print(node);
        System.out.println('\n');
        o.flatten(node);
        BinaryTrees.print(node);


    }
}
