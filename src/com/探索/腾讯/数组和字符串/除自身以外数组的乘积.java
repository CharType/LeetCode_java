package com.探索.腾讯.数组和字符串;

import com.sun.xml.internal.org.jvnet.mimepull.CleanUpExecutorFactory;
import com.tools.Integers;

/**
 * https://leetcode-cn.com/explore/interview/card/tencent/221/array-and-strings/907/
 */
public class 除自身以外数组的乘积 {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int [] ans = new int[nums.length];
        // 先求当前数左边的结果
        ans[0] = 1;
        for (int i = 1;i < ans.length;i++) {
            ans[i] = nums[i-1] * ans[i-1];
        }
        // 在求当前数右边的结果
        int r = 1;
        for (int i = length - 1;i >= 0;i--) {
            ans[i] = ans[i] * r;
            r *= nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        除自身以外数组的乘积 o = new 除自身以外数组的乘积();
        int [] num = {1,2,3,4};
        Integers.println(o.productExceptSelf(num));
    }
}
