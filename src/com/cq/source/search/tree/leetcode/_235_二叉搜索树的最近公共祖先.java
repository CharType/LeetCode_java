package com.cq.source.search.tree.leetcode;

import com.TreeNode.TreeNode;

/**
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/submissions/
 */
public class _235_二叉搜索树的最近公共祖先 {
    //todo:未完成
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);
        if (leftNode != null && rightNode != null) return root;
        if (leftNode != null && rightNode == null) return leftNode;
        if (leftNode == null && rightNode != null) return rightNode;
        if (root == p || root == q) return root;
        return null;
    }

    public static void main(String[] args) {

    }
}
