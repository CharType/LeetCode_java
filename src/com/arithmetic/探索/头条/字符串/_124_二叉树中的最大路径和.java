package com.arithmetic.探索.头条.字符串;

import com.arithmetic.TreeNode.TreeNode;

/**
 * https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 *
 * 递归
 * 计算当前层最大值 和右子树的最大值 然后取一个最大的值 + 当前节点值
 * 使用类中的属性累加所有的值
 */
public class _124_二叉树中的最大路径和 {
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        int num = oneSideMax(root);
        return ans;

    }

    public int oneSideMax(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(0,oneSideMax(root.left));
        int right = Math.max(0,oneSideMax(root.right));
        ans = Math.max(ans,left + right + root.val);

        return Math.max(left,right) + root.val;
    }



    public static void main(String[] args) {
        _124_二叉树中的最大路径和 o = new _124_二叉树中的最大路径和();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        System.out.println(o.maxPathSum(root));
    }


}
