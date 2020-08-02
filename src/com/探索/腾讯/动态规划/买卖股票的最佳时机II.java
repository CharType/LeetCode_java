package com.探索.腾讯.动态规划;

/**
 * https://leetcode-cn.com/leetbook/read/tencent/x507kd/
 */
public class 买卖股票的最佳时机II {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int val = 0;
        for (int i = 1;i < prices.length;i++) {
            if(prices[i] > prices[i-1]) {
                val += prices[i] - prices[i-1];
            }
        }
        return val;
    }

    public static void main(String[] args) {
        买卖股票的最佳时机II o = new 买卖股票的最佳时机II();
        int [] nums = {7,1,5,3,6,4};
        System.out.println(o.maxProfit(nums));
    }
}
