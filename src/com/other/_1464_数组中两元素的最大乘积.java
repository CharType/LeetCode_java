package com.other;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/maximum-product-of-two-elements-in-an-array/
 */
public class _1464_数组中两元素的最大乘积 {


    public int maxProduct(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;
        // 找出数组中的最大值和最大值的位置
        int scendVal = 0;
        int maxVal = nums[0];
        int maxIndex = 0;
        for (int i = 1;i < nums.length;i++) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
                maxIndex = i;
            }
        }
        // 找出数组中的第二大值，注意判断是否会有两个一样的最大值的情况
        for (int i = 0;i < nums.length;i++) {
            if (nums[i] > scendVal && i != maxIndex) {
                scendVal = nums[i];
            }
        }
        return (maxVal - 1) * (scendVal-1);
    }

    public static void main(String[] args) {
        _1464_数组中两元素的最大乘积 o = new _1464_数组中两元素的最大乘积();
//        int [] nums = {1,5,4,5};
//        System.out.println(o.maxProduct(nums));
//        int [] nums1 = {3,4,5,2};
//        System.out.println(o.maxProduct(nums1));
        int [] nums3 = {3,7};
        System.out.println(o.maxProduct(nums3));


    }

}
