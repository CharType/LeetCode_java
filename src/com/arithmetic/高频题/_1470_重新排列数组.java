package com.arithmetic.高频题;

import com.arithmetic.tools.Integers;

/**
 * https://leetcode-cn.com/problems/shuffle-the-array/
 */
public class _1470_重新排列数组 {
    public int[] shuffle(int[] nums, int n) {
        if (n <= 1) return nums;
        int [] temp = new int[nums.length];
        int index1 = 0;
        int index2 = n;
        for (int i = 0;i < nums.length;i++) {
            temp[i] = nums[index1++];
            i++;
            temp[i] = nums[index2++];
        }
        return temp;
    }

    public static void main(String[] args) {
        _1470_重新排列数组 o = new _1470_重新排列数组();
        int [] nums = {2,3,5,4,1,7};
        Integers.println(o.shuffle(nums,3));
    }
}
