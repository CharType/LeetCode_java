package com.arithmetic.cq.source.tree.leetcode;

import com.arithmetic.TreeNode.TreeNode;
import com.arithmetic.TreeNode.printer.BinaryTrees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 */
public class _144_二叉树的前序遍历 {
    // 递归
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorderTraversal(root, list);
        return list;

    }

    public List<Integer> preorderTraversal(TreeNode node, List<Integer> list) {
        if (node == null) return list;
        list.add(node.val);
        preorderTraversal(node.left, list);
        preorderTraversal(node.right, list);
        return list;
    }

    // 迭代方式
    public List<Integer> preorderTraversalStack(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);

            }

        }

        return list;
    }

    public static void main(String[] args) {
        _144_二叉树的前序遍历 o = new _144_二叉树的前序遍历();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        BinaryTrees.print(root);
        System.out.println('\n');
        System.out.println(o.preorderTraversalStack(root));
        System.out.println(o.preorderTraversal(root));
    }
}
