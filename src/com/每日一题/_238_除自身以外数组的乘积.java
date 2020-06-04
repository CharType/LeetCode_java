package com.每日一题;

import com.tools.Integers;

/**
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 * 示例:
 *
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/product-of-array-except-self
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _238_除自身以外数组的乘积 {
    public int[] productExceptSelf(int[] nums) {
        // 1.先计算所有的积
        int self = 1;
        for (int i= 0;i < nums.length;i++) {
            if (nums[i] != 0) {
                self *= nums[i];
            }
        }

        int [] producs = new int[nums.length];
        for (int i= 0;i < nums.length;i++) {
            if (nums[i] != 0) {
                producs[i] = self / nums[i];
            } else {
                producs[i] = self;
            }

        }
        return producs;



    }

    public static void main(String[] args) {
        _238_除自身以外数组的乘积 o = new _238_除自身以外数组的乘积();
        int [] nums = {1,0};
        Integers.println(o.productExceptSelf(nums));
    }
}
