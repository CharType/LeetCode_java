package com.精选Top面试题;

/**
 * https://leetcode-cn.com/problems/majority-element/
 */
public class _169_多数元素 {
    public int majorityElement(int[] nums) {
//        int n = nums.length >> 1;
        int value = nums[0];
        int count = 1;
        for (int i = 1; i< nums.length ; i++) {
            if (value == nums[i]) {
                count++;
            } else  {
                count--;
                if (count == 0) {
                    value = nums[i+1];
                }
            }
        }
        return value;
    }

    public static void main(String[] args) {
        _169_多数元素 o = new _169_多数元素();
        int [] nums = {9,2,2,1,1,1,1,2,9,9,9};
        System.out.println(o.majorityElement(nums));
    }
}
