package com.cq.source.tree.leetcode;

import com.TreeNode.TreeNode;

/**
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/submissions/
 */
public class _235_二叉搜索树的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) return root;
        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);
        if (leftNode != null && rightNode != null) return root;
        return (leftNode != null) ? leftNode : rightNode;
    }

    public static void main(String[] args) {

    }
}
