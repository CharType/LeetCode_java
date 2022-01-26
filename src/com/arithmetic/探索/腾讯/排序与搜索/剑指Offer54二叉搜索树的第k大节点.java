package com.arithmetic.探索.腾讯.排序与搜索;

import com.arithmetic.TreeNode.TreeNode;

import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
 */
public class 剑指Offer54二叉搜索树的第k大节点 {
    PriorityQueue<Integer> queue = new PriorityQueue<>();
    public int kthLargest(TreeNode root, int k) {
        if (root == null) return 0;
        kthLargest(root.right,k);
        if (queue.size()<k) {
            queue.add(root.val);
        } else {
            return queue.peek();
        }
        kthLargest(root.left,k);
        return queue.peek();
    }

    public static void main(String[] args) {
        剑指Offer54二叉搜索树的第k大节点 o =  new 剑指Offer54二叉搜索树的第k大节点();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(o.kthLargest(root,3));
    }
}
