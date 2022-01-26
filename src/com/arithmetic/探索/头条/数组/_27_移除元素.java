package com.arithmetic.探索.头条.数组;

import com.arithmetic.tools.Integers;

/**
 *
 */
public class _27_移除元素 {

    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        int count = 0;
        int length = nums.length;
        for (int i = 0;i < length;i++) {
            if (nums[i] == val) {
                count++;
                for (int j = i+1;j < length;j++) {
                    nums[j-1] = nums[j];
                }
                i--;
                length--;
            }
        }
        return nums.length - count;
    }

    public static void main(String[] args) {
        _27_移除元素 o = new _27_移除元素();
        int [] nums = {0,1,2,2,3,0,4,2};
        System.out.println(o.removeElement(nums,2));
        Integers.println(nums);
    }
}
