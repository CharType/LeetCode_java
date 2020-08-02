package com.探索.快手;

import java.util.Arrays;

/**
 *
 */
public class _300_最长上升子序列 {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int maxval = 1;
        int [] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1;i < nums.length;i++) {
            dp[i] = 1;
            for (int j = 0;j < i;j++) {
                if (nums[i] <= nums[j]) continue;
                dp[i] = Math.max(dp[i],dp[j] + 1);
            }
            maxval = Math.max(maxval,dp[i]);
        }
        return maxval;
    }


    public static void main(String[] args) {
        _300_最长上升子序列 o = new _300_最长上升子序列();
        int [] nums = {10,9,2,5,3,7,101,18};
//        int [] nums = {4,10,4,3,8,9};
        System.out.println(o.lengthOfLIS(nums));
    }
}
