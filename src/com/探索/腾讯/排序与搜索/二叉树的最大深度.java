package com.探索.腾讯.排序与搜索;


import com.TreeNode.TreeNode;
import com.linkList.ListNode;
import com.tools.Asserts;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


/**
 * https://leetcode-cn.com/explore/interview/card/tencent/224/sort-and-search/930/
 */
public class 二叉树的最大深度 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left,right) + 1;
    }

    public int maxDepth1(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int count = 0;
        Queue<TreeNode> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()) {
            count++;
            int len = list.size();
            for (int i = 0;i < len;i++) {
                TreeNode node = list.remove();
                if (node.left != null) list.add(node.left);
                if (node.right != null) list.add(node.right);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        二叉树的最大深度 o = new 二叉树的最大深度();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        Asserts.test(o.maxDepth(root) == o.maxDepth1(root));

    }
}
