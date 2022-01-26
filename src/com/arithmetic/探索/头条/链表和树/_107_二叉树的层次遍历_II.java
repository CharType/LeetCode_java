package com.arithmetic.探索.头条.链表和树;

import com.arithmetic.TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 * // 从前往后遍历，从上往下遍历，每一次都将每一层的数据获取到最前面
 */
public class _107_二叉树的层次遍历_II {



    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        // 创建一个辅助队列
        Queue<TreeNode> queue = new LinkedList<>();
        // 将根节点入队
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> tempList = new ArrayList<>();
            int len = queue.size();
            for (int i = 0; i < len;i++) {
                TreeNode node = queue.poll();
                tempList.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            list.add(0,tempList);
        }
        return list;
    }



    public static void main(String[] args) {
        _107_二叉树的层次遍历_II o = new _107_二叉树的层次遍历_II();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(o.levelOrderBottom(root));

    }
}
