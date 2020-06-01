package com.sort;

import com.tools.Integers;

import java.util.Arrays;

/**
 *https://leetcode-cn.com/problems/squares-of-a-sorted-array/submissions/
 */
public class _977_有序数组的平方 {
    public int[] sortedSquares1(int[] nums) {
        /**
         * 时间复杂度：O(n+n*logn)
         * 空间复杂度O(n)
         */
        if (nums == null || nums.length == 0) return nums;
        int [] newNums = new int [nums.length];
        for (int i = 0; i < nums.length ; i++) {
            newNums[i] = nums[i] * nums[i];
        }
        Arrays.sort(newNums);
        return newNums;
    }
    public int[] sortedSquares(int[] nums) {
        if (nums == null || nums.length == 0) return nums;
        /**
         * 时间复杂度：O(n)
         * 空间复杂度 O(n)
         */
        int [] newNums = new int [nums.length];
        int l = 0;
        int r = nums.length - 1;
        int insertIndex = nums.length - 1;
        while (l < r) {
            if (nums[l] * nums[l] > nums[r] * nums[r]) {
                newNums[insertIndex--] = nums[l] * nums[l];
                l++;
            } else {
                newNums[insertIndex--] = nums[r] * nums[r];
                r--;
            }
        }
        return newNums;
    }

    public static void main(String[] args) {
        _977_有序数组的平方 o = new _977_有序数组的平方();
        int [] nums = {-4, -1, 0,3,10};
        Integers.println(o.sortedSquares(nums));
    }
}
