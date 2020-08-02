package com.探索.快手;

import com.TreeNode.TreeNode;

/**
 * https://leetcode-cn.com/problems/delete-node-in-a-bst/
 */
public class _450_删除二叉搜索树中的节点 {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (key < root.val) {
            root.left = deleteNode(root.left,key);
        } else if(key > root.val) {
            root.right = deleteNode(root.right,key);
        } else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            TreeNode node = findMaxNode(root.left);
            root.val = node.val;
            root.left = deleteNode(root.left,root.val);
        }
        return root;
    }

    // 查找对应的前驱节点或者后继节点
    public TreeNode findMaxNode(TreeNode node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    public static void main(String[] args) {
        _450_删除二叉搜索树中的节点 o = new _450_删除二叉搜索树中的节点();
//        TreeNode rootNode = new TreeNode(5);
//        rootNode.left = new TreeNode(3);
//        rootNode.right = new TreeNode(6);
//        rootNode.left.left = new TreeNode(2);
//        rootNode.left.right = new TreeNode(4);
//        rootNode.right.right = new TreeNode(7);
        TreeNode rootNode = new TreeNode(1);
        rootNode.right = new TreeNode(2);
        o.deleteNode(rootNode,2);
        System.out.println(rootNode);
    }
}
