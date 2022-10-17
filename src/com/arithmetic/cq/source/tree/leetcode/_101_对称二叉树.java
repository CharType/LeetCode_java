package com.arithmetic.cq.source.tree.leetcode;

import com.arithmetic.TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/symmetric-tree/
 */
public class _101_对称二叉树 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        queue.offer(root);
        int leveSize = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            leveSize--;
            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
            if (leveSize == 0) {
                int begin = 0;
                int end = list.size() - 1;
                while (begin <= end) {
                    if (list.get(begin) != list.get(end)) {
                        return false;
                    }
                    begin++;
                    end--;
                }
                leveSize = queue.size();
                list.clear();
            }
        }
        return true;
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

        System.out.println(o.isSymmetric(root));
    }
}
