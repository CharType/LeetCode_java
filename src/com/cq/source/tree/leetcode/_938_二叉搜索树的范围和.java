package com.cq.source.tree.leetcode;

import com.TreeNode.TreeNode;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/range-sum-of-bst/
 */
public class _938_二叉搜索树的范围和 {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        int sum = 0;
        boolean issum = false;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.add(node);
                node = node.left;
            } else {
                if (stack.isEmpty()) {
                    break;
                } else {
                    TreeNode tempNode = stack.pop();
                    if (tempNode.val == low || issum) {

                        issum = true;
                        sum += tempNode.val;
                        if (tempNode.val == high) {
                            issum = false;
                            return sum;
                        }
                    }

                    node = tempNode.right;
                }

            }
        }
        return sum;
    }

    public static void main(String[] args) {
        _938_二叉搜索树的范围和 o = new _938_二叉搜索树的范围和();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right = new TreeNode(15);
        root.right.right = new TreeNode(18);
        System.out.println(o.rangeSumBST(root, 7, 15));

    }
}
