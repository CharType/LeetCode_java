package com.精选Top面试题.简单;

import com.tools.Integers;

/**
 *https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
public class _26_删除排序数组中的重复项 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int i = 0;// 记录最后的
        for (int j = 1;j<nums.length;j++) {
            if (nums[i] != nums[j]) { // 如果2个数相等，就跳到后面一个不等于的数字，，放到这个数字第一个位置
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public void swap(int [] nums,int l,int r){
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

    public static void main(String[] args) {
        _26_删除排序数组中的重复项 o = new _26_删除排序数组中的重复项();
        int [] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(o.removeDuplicates(nums));
    }
}
