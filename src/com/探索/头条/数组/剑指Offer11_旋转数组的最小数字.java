package com.探索.头条.数组;

/**
 * https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 */
public class 剑指Offer11_旋转数组的最小数字 {
    public int minArray(int[] numbers) {
        int minValue = numbers[0];
        for (int i = 1;i < numbers.length;i++) {
            if (numbers[i] < numbers[i-1]) {
                minValue = numbers[i];
                return minValue;
            }
        }
        return minValue;
    }

    public static void main(String[] args) {
        剑指Offer11_旋转数组的最小数字 o  = new 剑指Offer11_旋转数组的最小数字();

        int [] nums = {3,4,5,1,2};
        System.out.println(o.minArray(nums));
    }
}
