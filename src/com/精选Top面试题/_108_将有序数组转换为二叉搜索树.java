package com.精选Top面试题;

import com.TreeNode.TreeNode;

/**
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 */
public class _108_将有序数组转换为二叉搜索树 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        if (nums.length == 1) return new TreeNode(nums[0]);
        // 1.找到中间值 离中位数最近的值
        int middleIndex = nums.length >> 1;
        TreeNode root = new TreeNode(nums[middleIndex]);
        root.left = createTreeeNode(nums,0,middleIndex);
        root.right = createTreeeNode(nums,middleIndex+1,nums.length);
        return root;
    }
    public TreeNode createTreeeNode(int [] nums,int l,int r) {
        if (l == r) return null;
        int middleIndex = ((r - l) >> 1) + l;
        TreeNode root = new TreeNode(nums[middleIndex]);
        root.left = createTreeeNode(nums,l,middleIndex);
        root.right = createTreeeNode(nums,middleIndex+1,r);
        return root;
    }

    public static void main(String[] args) {
        _108_将有序数组转换为二叉搜索树 o = new _108_将有序数组转换为二叉搜索树();
        int [] nums = {-10,-3,0,5,9};
        TreeNode root = o.sortedArrayToBST(nums);
        System.out.println(root);
    }
}
