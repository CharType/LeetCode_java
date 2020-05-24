package com.高频题;

import com.tools.Integers;

import java.util.HashMap;
import java.util.Map;

public class _1_两数之和 {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length <= 2) return null;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i<nums.length;i++) {
            Integer index = map.get(target - nums[i]);
            if (index != null) {
                return new int[]{index, i};
            }
            map.put(nums[i],i);
        }
        return null;
    }

    public static void main(String[] args) {
        _1_两数之和 o = new _1_两数之和();
        int [] nums = o.twoSum(new int[]{2, 7, 11, 15},18);
        Integers.println(nums);
    }
}
