package com.arithmetic.探索.头条.动态规划;

/**
 * 一遍遍历，如果价格变大，将每次之间的差值和计算起来，得到最终的结果
 */
public class _122_买卖股票的最佳时机_II {
    public int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 1;i < prices.length;i++) {
            if (prices[i] > prices[i-1]) {
                sum += prices[i] - prices[i-1];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        _122_买卖股票的最佳时机_II o = new _122_买卖股票的最佳时机_II();
        int [] nums = {1,2,3,4,5};
        System.out.println(o.maxProfit(nums));

    }
}
