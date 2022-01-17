package com.cq.source.tenxun;

import com.TreeNode.TreeNode;

public class _124_二叉树中的最大路径和 {
    // 记录结果
    int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        // 递归调用
        oneSideMax(root);
        return ans;
    }

    public int oneSideMax(TreeNode root) {
        if (root == null) return 0;
        // 左边节点的最大值
        int left = Math.max(0, oneSideMax(root.left));
        // 右边节点的最大值
        int right = Math.max(0, oneSideMax(root.right));
        // 最大路劲值等于左边节点的值 + 右边节点的值 + 根节点的值，然后记录下来
        ans = Math.max(left + right + root.val, ans);
        // 返回左边节点或者右边节点中比较大的那个值 + 根节点
        return Math.max(left, right) + root.val;
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
