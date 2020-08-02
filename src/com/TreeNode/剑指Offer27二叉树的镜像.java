package com.TreeNode;

public class 剑指Offer27二叉树的镜像 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        mirrorTree(root.left);
        mirrorTree(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        剑指Offer27二叉树的镜像 o = new 剑指Offer27二叉树的镜像();
        o.mirrorTree(root);
    }
}
