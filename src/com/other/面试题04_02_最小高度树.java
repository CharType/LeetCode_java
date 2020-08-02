package com.other;

import com.TreeNode.TreeNode;

/**
 * https://leetcode-cn.com/problems/minimum-height-tree-lcci/
 * // 根据一个有序的数组还原一个二叉搜索树
 */
public class 面试题04_02_最小高度树 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) return null;
        if (nums.length == 1) return new TreeNode(nums[0]);
        return sortedArrayToBST(nums,0,nums.length-1);
    }

    public TreeNode sortedArrayToBST(int[] nums,int li,int ri) {
        if (li > ri) return null;
        int rootIndex = (li + ri) / 2;
        TreeNode rootNode = new TreeNode(nums[rootIndex]);
        rootNode.left = sortedArrayToBST(nums,li,rootIndex-1);
        rootNode.right = sortedArrayToBST(nums,rootIndex+1,ri);
        return rootNode;
    }

    public static void main(String[] args) {
        面试题04_02_最小高度树 o = new 面试题04_02_最小高度树();
        int [] nums = {-10,-3,0,5,9};
        TreeNode root = o.sortedArrayToBST(nums);
        System.out.println(root);
    }

}
