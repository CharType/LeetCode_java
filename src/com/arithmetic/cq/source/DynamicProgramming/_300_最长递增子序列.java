package com.arithmetic.cq.source.DynamicProgramming;

/**
 * 严格上升
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * <p>
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 */
public class _300_最长递增子序列 {

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int[] dp = new int[nums.length];
        int maxLength = dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        _300_最长递增子序列 o = new _300_最长递增子序列();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(o.lengthOfLIS(nums));
    }
}
