package com.arithmetic.探索.腾讯.数组和字符串;

import com.arithmetic.tools.Integers;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/explore/interview/card/tencent/221/array-and-strings/894/
 */
public class 两数之和 {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 1) return new int[0];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i< nums.length;i++) {
            Integer index = map.get(nums[i]);
            if (index != null) {
                int [] targets = {index,i};
                return targets;
            } else  {
               int val = target - nums[i];
               map.put(val,i);
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        两数之和 o = new 两数之和();
        int [] nums = {2, 7, 11, 15};
        Integers.println(o.twoSum(nums,9));
    }
}
