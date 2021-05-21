package com.探索.腾讯.数学与数字;

import java.util.HashSet;
import java.util.Set;

/**
 *
 */
public class 只出现一次的数字 {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }


    public static void main(String[] args) {
        只出现一次的数字 o = new 只出现一次的数字();
        int [] nums = {4,1,2,1,2};
        System.out.println(o.singleNumber(nums));
    }
}
