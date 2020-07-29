package com.动态规划;

/**
 * https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 */
public class _剑指Offer42_连续子数组的最大和 {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int [] dp = new int[nums.length];
        dp[0] = nums[0];
        int maxValue = dp[0];
        for (int i = 1;i < nums.length;i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
            maxValue = Math.max(maxValue,dp[i]);
        }
        return maxValue;
    }

    public int maxSubArray1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int dpOne = nums[0];
        int dptwo = 0;
        int maxValue = dpOne;
        for (int i = 1;i < nums.length;i++) {
            if (dpOne > 0) {
                dptwo = dpOne + nums[i];
            } else {
                dptwo = nums[i];
            }
            dpOne = dptwo;
            maxValue = Math.max(maxValue,dptwo);
        }
        return maxValue;
    }

    public static void main(String[] args) {
        _剑指Offer42_连续子数组的最大和 o = new _剑指Offer42_连续子数组的最大和();
        int [] nums = {-2,1,1,4,-1,2,1,-5,4};
        System.out.println(o.maxSubArray1(nums));
    }
}
