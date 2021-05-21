package com.探索.头条.动态规划;


/**
 * https://leetcode-cn.com/problems/maximum-subarray/
 * 一遍遍历 上次的值 + nums[i] 和当前的nums[i] 取最大值
 * 取一遍遍历后的最大值
 */
public class _53_最大子序和 {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int pre = 0;
        int maxans = nums[0];
        for (int i = 1;i < nums.length;i++) {
            pre = Math.max(pre + nums[i],nums[i]);
            maxans = Math.max(maxans,pre);
        }
        return maxans;
    }

    public static void main(String[] args) {
        _53_最大子序和 o = new _53_最大子序和();
        int [] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(o.maxSubArray(nums));
    }
}
