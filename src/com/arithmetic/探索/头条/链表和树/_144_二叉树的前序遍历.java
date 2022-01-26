package com.arithmetic.探索.头条.链表和树;

import com.arithmetic.TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 * 前序遍历 先遍历自己，在遍历右节点，在遍历左节点
 */
public class _144_二叉树的前序遍历 {
    private List<Integer> list = new ArrayList<>();
    // 递归版本
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        list.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return list;
    }

    //非递归版本
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        list.add(root.val);
        if (root.right != null) {
            stack.add(root.right);
        }
        TreeNode treeNode = root.left;
        while (treeNode != null || !stack.isEmpty()) {
            if (treeNode != null) {
                list.add(treeNode.val);
                if (treeNode.right != null) {
                    stack.add(treeNode.right);
                }
                treeNode = treeNode.left;
                continue;
            }
            if (!stack.isEmpty()) {
                TreeNode rightTreeNode = stack.pop();
                list.add(rightTreeNode.val);
                if (rightTreeNode.right != null) {
                    stack.add(rightTreeNode.right);
                }
                treeNode = rightTreeNode.left;
                continue;
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
        System.out.println(o.preorderTraversal1(root));
        System.out.println(o.preorderTraversal(root));
    }
}
