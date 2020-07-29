package com.探索.腾讯.数组和字符串;

import com.tools.Asserts;

import java.util.HashSet;
import java.util.Set;

public class 存在重复元素 {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length <= 1) return false;
        Set<Integer> set = new HashSet<>();
        for (int i = 0;i < nums.length;i++) {
            if (set.contains(nums[i])) {
                return true;
            } else {
                set.add(nums[i]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        存在重复元素 o = new 存在重复元素();
        int [] num1 = {1,1,1,3,3,4,3,2,4,2};
        Asserts.test(o.containsDuplicate(num1) == true);

        int [] num2 = {1,2,3,1};
        Asserts.test(o.containsDuplicate(num2) == true);

        int [] num3 = {1,2,3,4};
        Asserts.test(o.containsDuplicate(num3) == false);
    }
}
