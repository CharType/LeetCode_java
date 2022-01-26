package com.arithmetic.探索.头条.链表和树;

import com.arithmetic.TreeNode.TreeNode;

import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
 */
public class _230_二叉搜索树中第K小的元素 {
    PriorityQueue<Integer> queue = new PriorityQueue<>((Integer o1,Integer o2) -> o2 - o1);
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return 0;
        kthSmallest(root.left,k);
        if (queue.isEmpty() || queue.size() < k) {
            queue.add(root.val);

        } else if (queue.peek() > root.val) {
            queue.remove();
            queue.add(root.val);
        }
        if (queue.size() == k) {
            return queue.peek();
        }

        kthSmallest(root.right,k);
        return queue.peek();
    }
    public static void main(String[] args) {
        _230_二叉搜索树中第K小的元素 o = new _230_二叉搜索树中第K小的元素();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(o.kthSmallest(root,2));
    }
}
