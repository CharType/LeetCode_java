package com.arithmetic.探索.腾讯.动态规划;

/**
 * https://leetcode-cn.com/leetbook/read/tencent/x5dugs/
 */
public class 买卖股票的最大时机 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        // 存储最终结果
        int val = 0;
        // 记录上次的最小值
        int minValue = Integer.MAX_VALUE;
        for (int price: prices) {
            if (price < minValue) {
                minValue = price;
            } else {
                val = Math.max(val,price - minValue);
            }
        }
        return val;
    }
    public static void main(String[] args) {
        买卖股票的最大时机 o = new 买卖股票的最大时机();
        int [] nums = {7,1,5,3,6,4};
        System.out.println(o.maxProfit(nums));
    }
}
