package com.精选Top面试题.简单;

import com.tools.Integers;

/**
 *https://leetcode-cn.com/problems/rotate-array/
 */
public class _189_旋转数组 {
    public void rotate(int[] nums, int k) {
        if (nums == null) return;;
        if (nums.length <=1) return;
        int num = k % nums.length;
        if (k == 0) return;
        int leftindex = 0;
        int rightIndex = nums.length - k ;
        while (rightIndex < nums.length) {
            int temp = nums[leftindex];
            nums[leftindex] = nums[rightIndex];
            nums[rightIndex] = temp;
            leftindex++;
            rightIndex++;
        }
    }

    public static void main(String[] args) {
        _189_旋转数组 o = new _189_旋转数组();
        int [] nums = {1,2,3,4,5,6,7};
        o.rotate(nums,3);
        Integers.println(nums);
    }
}
