package com.探索.头条.链表和树;

import com.TreeNode.TreeNode;
import com.linkList.ListNode;
import com.sun.xml.internal.org.jvnet.mimepull.CleanUpExecutorFactory;

/**
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class _236_二叉树的最近公共祖先 {

    /**
     * 如果p和q同时存在这颗二叉树中，直接返回公共的祖先
     * 如果p和q都不存在这颗二叉树中直接返回null
     * 如果只有p存在这颗二叉树中返回p
     * 如果只有q存在这颗二叉树中 返回q
     * @param root
     * @param p
     * @param q
     * @return  递归方式
     * 使用迭代方式
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return  root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if (left != null && right != null) return root;
        return left != null ? left : right;

//        if (left == null && right == null) return  null;
//
//        if (left != null && right == null) return left;
//        if (left == null && right != null) return right;
//        return null;
    }

    public static void main(String[] args) {

    }
}
