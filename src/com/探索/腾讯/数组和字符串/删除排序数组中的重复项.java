package com.探索.腾讯.数组和字符串;

import com.tools.Integers;

/**
 * https://leetcode-cn.com/explore/interview/card/tencent/221/array-and-strings/902/
 */
public class 删除排序数组中的重复项 {
    public int removeDuplicates(int[] nums) {
        if (nums == null) return 0;
        if (nums.length == 1) return 1;
        int count = 0;
        for (int i = 0;i < nums.length;i++) {

        }
        return nums.length - count;
    }

    public static void main(String[] args) {
        删除排序数组中的重复项 o = new 删除排序数组中的重复项();
        int [] nums = {0,0,1,1,1,2,2,3,3,4};
        o.removeDuplicates(nums);
        Integers.println(nums);
    }
}
