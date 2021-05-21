package com.other;

import com.tools.Integers;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/how-many-numbers-are-smaller-than-the-current-number/
 */
public class _1365_有多少小于当前数字的数字 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        if (nums == null || nums.length == 0) return new int[0];
        int [] result = new int[101];
        // 先统计每个数的出现次数
        for (int i = 0;i < nums.length;i++) {
            result[nums[i]]++;
        }
        int pre = 0,next = 0;
        // 将每次出现的数和之前的数字累计
        for (int i = 0;i < 101;i++){
            int val = result[i];
            if (result[i] > 0) {
                result[i] = pre;
            }
            pre += val;
        }
        // 更新数组中的值
        for (int i = 0;i < nums.length;i++) {
            nums[i] = result[nums[i]];
        }
        return nums;

    }
    public static void main(String[] args) {
        _1365_有多少小于当前数字的数字 o = new _1365_有多少小于当前数字的数字();
        int [] nums = {8,1,2,2,3};
        Integers.println(o.smallerNumbersThanCurrent(nums));
    }
}
