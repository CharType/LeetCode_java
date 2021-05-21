package com.精选Top面试题.中等;

import com.TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 */
public class _103_二叉树的锯齿形层次遍历 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // 没有数据直接返回一个空的数组
        if (root == null) return new ArrayList<List<Integer>>();
        // 最后需要返回的那个数组
        List<List<Integer>> results = new ArrayList<>();
        // 双端队列
        LinkedList<TreeNode> node_queue = new LinkedList<>();
        // 先将root节点擦插入到尾部，
        node_queue.addLast(root);
        // 并且插入一个null的标志位
        node_queue.addLast(null);
        // 保存每一层的数据的list
        LinkedList<Integer> level_list = new LinkedList<>();
        // 定义一个标志位，控制插入数据的方向
        boolean is_order_left = true;
        // 如果队列中有数据一直遍历
        while (node_queue.size() > 0) {
            // 从队列头取出一个节点
            TreeNode curr_node = node_queue.pollFirst();
            if (curr_node != null) {
                // 如果节点不等于null 就根据标志位的值将节点的值插入到当前层的数组中去
                if (is_order_left) {
                    level_list.addLast(curr_node.val);
                } else {
                    level_list.addFirst(curr_node.val);
                }

                // 如果当前节点的左节点不为null,将左节点插入队列尾部
                if (curr_node.left != null) {
                    node_queue.addLast(curr_node.left);
                }
                // 如果当前节点的右节点不为null，将右节点插入到队尾
                if (curr_node.right != null) {
                    node_queue.addLast(curr_node.right);
                }
            } else {
                // 如果取出的节点为bull 说明一层数据已经遍历完成，将数据保存起来
                results.add(level_list);
                // 重新创建容器
                level_list = new LinkedList<Integer>();
                if (node_queue.size() > 0) {
                    // 队列中有值，是下一层的值，插入一个null做为标志位
                    node_queue.addLast(null);
                }
                // 修改插入方向的标志位，取反，以便下次遍历的时候展示数据和当前层的数据相反
                is_order_left = !is_order_left;
            }
        }
        return results;
    }

    public static void main(String[] args) {
        _103_二叉树的锯齿形层次遍历 o = new _103_二叉树的锯齿形层次遍历();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(o.zigzagLevelOrder(root));

    }
}
