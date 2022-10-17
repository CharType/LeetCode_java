package com.arithmetic.cq.source.tree.leetcode;

import com.arithmetic.TreeNode.TreeNode;
import com.arithmetic.TreeNode.printer.BinaryTrees;

/**
 * https://leetcode-cn.com/problems/search-in-a-binary-search-tree/
 */
public class _700_二叉搜索树中的搜索 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        TreeNode node = root;
        while (node != null) {
            if (node.val == val) {
                return node;
            } else if (node.val > val) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        _700_二叉搜索树中的搜索 o = new _700_二叉搜索树中的搜索();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);
        BinaryTrees.print(o.searchBST(root, 2));
    }
}
