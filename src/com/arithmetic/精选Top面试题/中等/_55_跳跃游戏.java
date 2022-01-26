package com.arithmetic.精选Top面试题.中等;

/**
 * https://leetcode-cn.com/problems/jump-game/
 */
public class _55_跳跃游戏 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int max = 0;
        for (int i = 0;i < n;i++) {
            if (i <= max) {
                max = Math.max(max,i+nums[i]);
                if (max >= n-1) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        _55_跳跃游戏 o = new _55_跳跃游戏();
        int [] nums = {2,3,1,1,4};
        int [] nums1 = {3,2,1,0,4};
        System.out.println(o.canJump(nums));
        System.out.println(o.canJump(nums1));
    }
}
