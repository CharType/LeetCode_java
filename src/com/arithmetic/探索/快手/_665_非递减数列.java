package com.arithmetic.探索.快手;

/**
 * https://leetcode-cn.com/problems/non-decreasing-array/
 * 本质上是找看有几个逆序对
 */
public class _665_非递减数列 {
    public boolean checkPossibility(int[] nums) {
        if (nums == null) return false;

        int count = 0;
        for (int i = 1;i < nums.length;i++) {
            if (nums[i] >= nums[i-1]) {
                continue;
            }
            count++;
            if (i - 2 >= 0 && nums[i - 2] > nums[i]) {
                nums[i] = nums[i-1];
            } else {
                nums[i-1] = nums[i];
            }
        }
        return count <= 1;
    }

    public static void main(String[] args) {
        _665_非递减数列 o = new _665_非递减数列();
//        int [] nums = {4,2,3};
//        int [] nums = {3,4,2,3};
        int [] nums = {1,1,1};
        System.out.println(o.checkPossibility(nums));
    }
}
