package com.arithmetic.cq.source.tree.leetcode;

import com.arithmetic.TreeNode.TreeNode;
import com.arithmetic.TreeNode.printer.BinaryTrees;

/**
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 */
public class _108_将有序数组转换为二叉搜索树 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        if (nums.length == 1) return new TreeNode(nums[0]);
        int rootIndex = nums.length >> 1;
        TreeNode node = new TreeNode(nums[rootIndex]);

        int[] leftnums = new int[rootIndex];
        for (int i = 0; i < rootIndex; i++) {
            leftnums[i] = nums[i];
        }
        int[] rightnums = new int[nums.length - rootIndex - 1];
        for (int i = rootIndex + 1; i < nums.length; i++) {
            rightnums[i - (rootIndex + 1)] = nums[i];
        }
        node.left = sortedArrayToBST(leftnums);
        node.right = sortedArrayToBST(rightnums);
        return node;
    }

    public static void main(String[] args) {
        _108_将有序数组转换为二叉搜索树 o = new _108_将有序数组转换为二叉搜索树();
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        BinaryTrees.print(o.sortedArrayToBST(nums));
    }
}
