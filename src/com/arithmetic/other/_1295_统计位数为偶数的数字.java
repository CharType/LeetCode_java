package com.arithmetic.other;

/**
 * https://leetcode-cn.com/problems/find-numbers-with-even-number-of-digits/
 */
public class _1295_统计位数为偶数的数字 {
    public int findNumbers(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int value = 0;
        for (int i = 0;i < nums.length;i++) {
            int num = nums[i];
            int count = 1;
            while (num >= 10) {
                num = num / 10;
                count++;
            }
            if (count % 2 == 0) value++;
        }
        return value;
    }

    public static void main(String[] args) {
        _1295_统计位数为偶数的数字 o = new _1295_统计位数为偶数的数字();
//        int [] nums = {12,345,2,6,7896};
        int [] nums = {100000};
        System.out.println(o.findNumbers(nums));
    }
}
