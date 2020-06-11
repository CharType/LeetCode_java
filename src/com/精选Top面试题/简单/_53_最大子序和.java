package com.精选Top面试题.简单;

import com.tools.Integers;

/**
 *https://leetcode-cn.com/problems/maximum-subarray/
 */
public class _53_最大子序和 {
    public int maxSubArray(int[] nums) {
        int pre = 0;
        int maxAns = nums[0];

        for (int i = 0;i < nums.length;i++) {
            pre = Math.max(pre + nums[i],nums[i]);
            maxAns = Math.max(maxAns,pre);

        }
        return maxAns;
    }

    public static void main(String[] args) {
        _53_最大子序和 o = new _53_最大子序和();
        int [] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(o.maxSubArray(nums));
    }
}
