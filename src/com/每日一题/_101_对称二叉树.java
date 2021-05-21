package com.每日一题;

import com.TreeNode.TreeNode;

/**
 * https://leetcode-cn.com/problems/symmetric-tree/
 */
public class _101_对称二叉树 {

    public boolean isSymmetric1(TreeNode root) {
        if (root == null) return true;




        return cheeck(root.left, root.right);

    }

    public boolean cheeck(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null && right != null) return false;
        if (right == null && left != null) return false;

        return left.val == right.val && cheeck(left.left,right.right) && cheeck(left.right,right.left);

    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right != null) return false;
        if (root.right == null && root.left != null) return false;
        if (root.left == null && root.right == null) return true;
        // 左子树前序遍历，右子树后续比那里  然后比较字符串
        // 序列化左子树和右子树，然后比较序列化之后的数据
        StringBuilder leftsb = new StringBuilder();
        seriation(root.left, leftsb, true);

        StringBuilder rightsb = new StringBuilder();
        seriation(root.right, rightsb, false);

        return leftsb.toString().equals(rightsb.toString());

    }

    public void seriation(TreeNode node, StringBuilder sb,boolean isfront) {
        if (node == null) {
            sb.append("#!");
            return;
        }
        if (isfront) {
            seriation(node.left, sb, isfront);
            seriation(node.right, sb, isfront);
        } else {
            seriation(node.right, sb,isfront);
            seriation(node.left, sb,isfront);
        }

        sb.append(node.val).append("!");
    }

    public static void main(String[] args) {
        _101_对称二叉树 o = new _101_对称二叉树();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        System.out.println(o.isSymmetric1(root));
    }
}
