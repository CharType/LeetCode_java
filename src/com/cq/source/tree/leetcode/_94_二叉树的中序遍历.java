package com.cq.source.tree.leetcode;

import com.TreeNode.TreeNode;
import com.TreeNode.printer.BinaryTrees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class _94_二叉树的中序遍历 {
    public List<Integer> inorderTraversalStack(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.add(node);
                node = node.left;
            } else {
                if (stack.isEmpty()) {
                    return list;
                } else {
                    TreeNode tempNode = stack.pop();
                    list.add(tempNode.val);
                    node = tempNode.right;
                }
            }

        }
        return list;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);
        return list;
    }

    public void inorderTraversal(TreeNode node, List<Integer> list) {
        if (node == null) return;
        inorderTraversal(node.left, list);
        list.add(node.val);
        inorderTraversal(node.right, list);
    }

    public static void main(String[] args) {
        _94_二叉树的中序遍历 o = new _94_二叉树的中序遍历();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        BinaryTrees.print(root);
        System.out.println('\n');
        System.out.println(o.inorderTraversal(root));
        System.out.println('\n');
        System.out.println(o.inorderTraversalStack(root));
    }
}
