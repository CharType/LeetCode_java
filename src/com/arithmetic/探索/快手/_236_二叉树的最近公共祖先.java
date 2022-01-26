package com.arithmetic.探索.快手;

import com.arithmetic.TreeNode.TreeNode;

/**
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/submissions/
 */
public class _236_二叉树的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 最重要的一步 递归截止条件
        if (root == null || root == p || root == q) return null;
        TreeNode leftNode = lowestCommonAncestor(root.left,p,q);
        TreeNode rightNode = lowestCommonAncestor(root.right,p,q);



        if (leftNode != null && rightNode == null) return leftNode;
        if (leftNode == null && rightNode != null) return rightNode;
        if (leftNode != null && rightNode != null) return root;
        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        _236_二叉树的最近公共祖先 o = new _236_二叉树的最近公共祖先();

    }
}
