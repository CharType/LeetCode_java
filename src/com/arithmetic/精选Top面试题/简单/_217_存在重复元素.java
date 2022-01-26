package com.arithmetic.精选Top面试题.简单;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/contains-duplicate/
 */
public class _217_存在重复元素 {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null) return false;
        if (nums.length == 1) return  false;
        Arrays.sort(nums);
        for (int i = 1;i < nums.length;i++) {
            if (nums[i] == nums[i-1]) {
                return true;
            }
        }
        return false;
    }

    public boolean containsDuplicate1(int[] nums) {
        if (nums == null) return false;
        if (nums.length == 1) return  false;

        List<Integer> set = new ArrayList<Integer>(nums.length);


        for (int i = 0;i < nums.length;i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        _217_存在重复元素 o = new _217_存在重复元素();
        int [] nums = {1,2,3,4,2};
        System.out.println(o.containsDuplicate1(nums));

    }
}
