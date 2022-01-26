package com.arithmetic.cq.source.tree.leetcode;

import com.arithmetic.TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
 */
public class _230_二叉搜索树中第K小的元素 {

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return -1;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        List<Integer> list = new ArrayList<>();
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.add(node);
                node = node.left;
            } else {
                if (stack.isEmpty()) {
                    break;
                } else {
                    TreeNode tempNode = stack.pop();
                    list.add(tempNode.val);
                    if (list.size() == k) {
                        return tempNode.val;
                    }
                    node = tempNode.right;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
