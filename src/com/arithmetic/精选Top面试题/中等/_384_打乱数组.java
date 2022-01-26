package com.arithmetic.精选Top面试题.中等;

import com.arithmetic.tools.Integers;

/**
 * https://leetcode-cn.com/problems/shuffle-an-array/
 */
public class _384_打乱数组 {
    Integer [] nums;
    public _384_打乱数组(Integer[] nums) {
        this.nums = nums;
    }


    public Integer[] reset() {
        return this.nums;
    }


    public Integer[] shuffle() {
        Integer [] nums = this.nums.clone();
        for (int i = nums.length-1;i>=0;i--) {
            int i2 = (int)(Math.random() * nums.length);
            swop(nums,i,(i2));
        }
        return nums;
    }

    public void swop(Integer [] nums, int i1,int i2) {
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }

    public static void main(String[] args) {
        Integer [] nums = Integers.random(10,1,20);
        _384_打乱数组 o = new _384_打乱数组(nums);
        System.out.println("元数据是");
        Integers.println(nums);
        System.out.println("打乱后的数据是");
        Integers.println(o.shuffle());
        System.out.println("打乱后的数据是");
        Integers.println(o.shuffle());
        System.out.println("打乱后的数据是");
        Integers.println(o.shuffle());

    }
}
