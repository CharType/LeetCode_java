package com.arithmetic.cq.source.tree.leetcode;

import com.arithmetic.TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 * https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/
 */
public class _783_二叉搜索树节点最小距离 {
    public int minDiffInBST(TreeNode root) {
        if (root == null) return 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        Integer chaValue = Integer.MAX_VALUE;
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
                    if (list.size() > 0) {
                        int maxValue = Math.max(tempNode.val, list.get(list.size() - 1));
                        int minValue = Math.min(tempNode.val, list.get(list.size() - 1));
                        chaValue = Math.min(chaValue, maxValue - minValue);
                    }
                    list.add(tempNode.val);

                    node = tempNode.right;
                }

            }
        }
        return chaValue;
    }

    public static void main(String[] args) {

    }
}
