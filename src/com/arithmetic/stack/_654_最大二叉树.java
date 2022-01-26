package com.arithmetic.stack;

public class _654_最大二叉树 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return findRootNode(nums,0,nums.length);
    }

    public TreeNode  findRootNode(int [] nums, int l, int r) {
        if (l == r) return null;
        int maxIndex = l;
        for (int i = l;i < r;i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        TreeNode rootNode = new TreeNode(nums[maxIndex]);
        rootNode.left = findRootNode(nums,l,maxIndex);
        rootNode.right = findRootNode(nums,maxIndex+1,r);
        return rootNode;
    }

    public static void main(String[] args) {
        _654_最大二叉树 o = new _654_最大二叉树();
        int [] nums = {3,2,1,6,0,5};

        System.out.println(o.constructMaximumBinaryTree(nums));
    }
}

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
