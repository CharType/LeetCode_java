package com.arithmetic.探索.头条.数组;

import com.arithmetic.tools.Integers;

/**
 * https://leetcode-cn.com/problems/running-sum-of-1d-array/
 */
public class _1480_一维数组的动态和 {
    public int[] runningSum(int[] nums) {
        if (nums == null || nums.length == 0) return new int[0];
        int sum = nums[0];
        int [] sums = new int[nums.length];
        sums[0] = sum;
        for (int i = 1;i < nums.length;i++) {
            sums[i] = sums[i-1] + nums[i];
        }
        return sums;
    }

    public static void main(String[] args) {
        _1480_一维数组的动态和 o = new _1480_一维数组的动态和();
        int [] nums = {3,1,2,10,1};
        Integers.println(o.runningSum(nums));
    }
}
