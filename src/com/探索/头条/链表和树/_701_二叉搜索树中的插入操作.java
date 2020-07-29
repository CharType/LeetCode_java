package com.探索.头条.链表和树;

import com.TreeNode.TreeNode;

/**
 * https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/
 */
public class _701_二叉搜索树中的插入操作 {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val > root.val) {
            TreeNode insertNode = insertIntoBST(root.right,val);
            if (insertNode != null)  root.right = insertNode;
        } else  {
            TreeNode insertNode = insertIntoBST(root.left,val);
            if (insertNode != null)  root.left = insertNode;
        }
        return root;
    }

    public static void main(String[] args) {
        _701_二叉搜索树中的插入操作 o = new _701_二叉搜索树中的插入操作();
        TreeNode rootNode = new TreeNode(4);
        rootNode.left = new TreeNode(2);
        rootNode.right = new TreeNode(7);
        rootNode.left.left = new TreeNode(1);
        rootNode.left.right = new TreeNode(3);
        System.out.println(o.insertIntoBST(rootNode,5));
        System.out.println(rootNode);
    }
}
