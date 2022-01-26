package com.arithmetic.探索.腾讯.排序与搜索;

import com.arithmetic.TreeNode.TreeNode;

import java.util.PriorityQueue;

/**
 *  https://leetcode-cn.com/explore/interview/card/tencent/224/sort-and-search/929/
 */
public class 二叉搜索树中第K小的元素 {
    PriorityQueue<Integer> queue = new PriorityQueue<>((Integer o1,Integer o2)-> o2 - o1);
    public int kthLargest(TreeNode root, int k) {
        if (root == null) return 0;
        kthLargest(root.left,k);
        if (queue.size() < k) {
            queue.add(root.val);
        } else {
            return queue.peek();
        }
        kthLargest(root.right,k);

        return queue.peek();
    }

    public static void main(String[] args) {
        二叉搜索树中第K小的元素 o = new 二叉搜索树中第K小的元素();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(o.kthLargest(root,4));
    }
}
