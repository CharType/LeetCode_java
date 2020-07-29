package com.探索.头条.链表和树;

import com.TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _103_二叉树的锯齿形层次遍历 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        return list;
    }

    public static void main(String[] args) {
        _103_二叉树的锯齿形层次遍历 o = new _103_二叉树的锯齿形层次遍历();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(o.zigzagLevelOrder(root));
    }
}
