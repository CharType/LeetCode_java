package com.arithmetic.每日一题;

import com.arithmetic.tools.Integers;

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
        int [] producs = new int[nums.length];
        for (int i= 0;i < nums.length;i++) {
            int leftIndex = i -1;
            int leftValue = 1;
            while (leftIndex >= 0) {
                leftValue *= nums[leftIndex];
                leftIndex--;
            }

            int rightIndex = i + 1;
            int rightValue = 1;
            while (rightIndex < nums.length) {
                rightValue *= nums[rightIndex];
                rightIndex++;
            }
            producs[i] = leftValue * rightValue;
        }
        return producs;
    }

    public int[] productExceptSelf1(int[] nums) {
        int length = nums.length;
        int [] ans = new int[nums.length];
        // 先统计每个数左边的值的积 = 这个数上一个左边的积 * 上一个数 一遍循环 统计好
        ans[0] = 1;
        for (int i = 1;i<ans.length;i++){
            ans[i] = nums[i-1] * ans[i -1];
        }
        // 在统计每个数右边的积值 = 这个数右边上一个数右边的积 * 右边数的值 ans中存的是左边的积，相乘结果就是左右两边的积
        int r = 1;
        for (int i = length -1;i>=0;i--) {
            ans[i] = ans[i] * r;
            r *= nums[i];
        }

        return ans;
    }



    public static void main(String[] args) {
        _238_除自身以外数组的乘积 o = new _238_除自身以外数组的乘积();
        int [] nums = {1,2,3,4};
        Integers.println(o.productExceptSelf1(nums));
    }
}
