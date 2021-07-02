package com.cq.source.search.tree.leetcode;

import com.TreeNode.TreeNode;
import com.TreeNode.printer.BinaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 */
public class _102_二叉树的层序遍历 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int levelSize = 1;
        List<Integer> levelList = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            levelList.add(node.val);
            levelSize--;
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
            if (levelSize == 0) {
                levelSize = queue.size();
                list.add(new ArrayList<>(levelList));
                levelList.clear();
            }
        }
        return list;
    }

    public static void main(String[] args) {
        _102_二叉树的层序遍历 o = new _102_二叉树的层序遍历();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        BinaryTrees.print(root);
        System.out.println('\n');
        System.out.println(o.levelOrder(root));
    }
}
