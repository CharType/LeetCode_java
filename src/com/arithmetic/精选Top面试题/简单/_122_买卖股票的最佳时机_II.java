package com.arithmetic.精选Top面试题.简单;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 */
public class _122_买卖股票的最佳时机_II {
    /**
     *
     * 在低价时候买入，高价时候卖出 如果是连续顺序峰值 得到的结果累加和是最后的高价 - 第一个最低价，本身就是最优解
     * ，所以直接可以这样计算
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;

        int maxValue = 0;

        for (int i = 1; i<prices.length;i++) {
            if (prices[i] > prices[i -1]) {
                maxValue += prices[i] - prices[i-1];
            }
        }

        return maxValue;
    }



    public static void main(String[] args) {
        _122_买卖股票的最佳时机_II o = new _122_买卖股票的最佳时机_II();
        int [] nums = {1,2,3,4,5};
        System.out.println(o.maxProfit(nums));
    }
}
