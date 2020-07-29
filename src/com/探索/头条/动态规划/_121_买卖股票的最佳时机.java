package com.探索.头条.动态规划;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意：你不能在买入股票前卖出股票。
 * 一次遍历，如果后一个比前一个小，记录最小值 如果大 是用那个当前值-最小值，然后记录这个最大值，遍历完成后就得到结果
 */
public class _121_买卖股票的最佳时机 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 1) return 0;
        // 存储最终结果
        int value = 0;
        // 记录上次的值
        int minValue = Integer.MAX_VALUE;
        for (Integer price :prices) {
            if (price < minValue) {
                // 如果当前的值比上次的值小，直接记录
                minValue = price;
            } else  {
                // 否则计算当前值的最大股票价值 当前值计算过了就可以忽略了
                value = Math.max(value,price - minValue);
            }
        }

        return value;

    }

    public static void main(String[] args) {
        _121_买卖股票的最佳时机 o = new _121_买卖股票的最佳时机();
        int[] prices = {7,8,5,3,6,4};
        System.out.println(o.maxProfit(prices));
    }
}
