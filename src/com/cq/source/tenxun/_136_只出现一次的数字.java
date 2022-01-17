package com.cq.source.tenxun;

public class _136_只出现一次的数字 {

    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = res ^ nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        _136_只出现一次的数字 o = new _136_只出现一次的数字();
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println(o.singleNumber(nums));
    }
}
