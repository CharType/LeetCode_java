package com.arithmetic.cq.source.sort.leetcode;


import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/maximum-gap/
 * 请尝试在线性时间复杂度和空间复杂度的条件下解决此问题。
 */
public class _164_最大间距 {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;
        // 使用计数排序或者桶排序

        int maxValue = 0;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            maxValue = Math.max(nums[i] - nums[i - 1], maxValue);
        }
        return maxValue;
    }

    public int maximumGap1(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;
        int maxValue = 0;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            maxValue = Math.max(nums[i] - nums[i - 1], maxValue);
        }
        return maxValue;
    }

    public static void main(String[] args) {
        _164_最大间距 o = new _164_最大间距();
        int[] nums = {3, 6, 9, 1};
    }
}
