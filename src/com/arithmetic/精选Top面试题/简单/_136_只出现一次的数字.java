package com.arithmetic.精选Top面试题.简单;

/**
 * https://leetcode-cn.com/problems/single-number/
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 */
public class _136_只出现一次的数字 {
    /**
     * 一个数字出现一次，其他数字只出现2次，可以使用异或运算 否则只能使用集合或者哈希表来统计出现的次数
     * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 不能使用额外的空间
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num:nums) {
            single ^= num;
        }
        return single;
    }

    public static void main(String[] args) {
        _136_只出现一次的数字 o = new _136_只出现一次的数字();
        int [] nums = {4,1,2,1,2};
        System.out.println(o.singleNumber(nums));
    }
}
