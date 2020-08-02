package com.探索.腾讯.数组和字符串;

import com.tools.Integers;

/**
 * https://leetcode-cn.com/explore/interview/card/tencent/221/array-and-strings/902/
 */
public class 删除排序数组中的重复项 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int i = 0;
        for (int j = 0;j < nums.length;j++) {
            if (nums[i] != nums[j]) {
                // 如果后一个数和前一个数不相等那么i++;
                i++;
                // 并且将后一个数添加到新的位置上去
                nums[i] = nums[j];
            }
        }
        return i;
    }

    public static void main(String[] args) {
        删除排序数组中的重复项 o = new 删除排序数组中的重复项();
        int [] nums = {0,0,1,1,1,2,2,3,3,4};
        o.removeDuplicates(nums);
        Integers.println(nums);
    }
}
