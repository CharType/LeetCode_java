package com.每日一题;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/find-the-duplicate-number/
 */
public class _287_寻找重复数 {
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length <= 2) return -1;
        Arrays.sort(nums);
        int temp = nums[0];
        for (int i = 1; i<nums.length; i++) {
            if (temp == nums[i]) {
                return temp;
            }
            temp = nums[i];

        }
        return 0;
    }

    public static void main(String[] args) {
        _287_寻找重复数 o = new  _287_寻找重复数();
        int [] nums = {1,3,4,2,2};
        System.out.println(o.findDuplicate(nums));
    }
}
