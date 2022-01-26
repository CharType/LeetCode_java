package com.arithmetic.探索.腾讯.数学与数字;

/**
 * https://leetcode-cn.com/explore/interview/card/tencent/223/math-and-numbers/941/
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
public class 多数元素 {
    public int majorityElement(int[] nums) {
        int ans = nums[0];
        int count = 1;
        for (int i = 1;i < nums.length;i++) {
            if (nums[i] == ans) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    ans = nums[i+1];
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        多数元素 o = new 多数元素();
        int [] nums = {2,2,1,1,1,2,2};
        System.out.println(o.majorityElement(nums));
    }
}
