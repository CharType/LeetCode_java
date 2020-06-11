package com.精选Top面试题.简单;

import com.tools.Integers;

/**
 *
 */
public class _66_加一 {

    public int[] plusOne(int[] digits) {
        if (digits == null) return digits;
        for (int i = digits.length-1;i>=0;i--) {
            if (digits[i] != 9) {
                digits[i]++;

                return digits;
            }
            digits[i] = 0;
        }
        int [] nums = new  int[digits.length +1];
        nums[0] = 1;
        return nums;

    }

    public static void main(String[] args) {
        _66_加一 o = new _66_加一();
        int [] nums = {9,9,8};
        Integers.println(o.plusOne(nums));

    }
}
