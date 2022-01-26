package com.arithmetic.每日一题;

/**
 * https://leetcode-cn.com/problems/house-robber/
 */
public class _198_打家劫舍 {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return nums[0] > nums[1] ? nums[0] : nums[1];
        int [] sums = new int [nums.length];
        sums[0] = nums[0];
        sums[1] = Math.max(nums[0], nums[1]);
        for (int i = 2;i< nums.length; i++) {
            sums[i] = Math.max(sums[i - 2] + nums[i], sums[i- 1]);
        }
        return sums[sums.length-1] ;
    }

    public static void main(String[] args) {
        _198_打家劫舍 o = new _198_打家劫舍();
        int [] nums = {2,1,1,2};
        System.out.println(o.rob(nums));
    }
}
