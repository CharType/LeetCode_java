package com.arithmetic.精选Top面试题.简单;

import com.arithmetic.tools.Integers;

/**
 *https://leetcode-cn.com/problems/rotate-array/
 */
public class _189_旋转数组 {
    public void rotate(int[] nums, int k) {
        if (nums == null) return;;
        if (nums.length <=1) return;
        int temp;
        while (k > 0) {
            temp = nums[nums.length-1];
            for (int i = nums.length -2;i >= 0;i--) {
                nums[i+1] = nums[i];
            }
            nums[0] = temp;
            k--;
        }
    }

    public static void main(String[] args) {
        _189_旋转数组 o = new _189_旋转数组();
        int [] nums = {1,2,3,4,5,6,7};
        o.rotate(nums,3);
        Integers.println(nums);
    }
}
