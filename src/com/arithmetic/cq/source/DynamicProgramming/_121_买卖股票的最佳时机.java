package com.arithmetic.cq.source.DynamicProgramming;

/**
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * <p>
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * dp[i] 第i天卖出的时候 股票获得的最大价值
 */
public class _121_买卖股票的最佳时机 {
    public static void main(String[] args) {
//        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int value = 0;
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minValue) {
                minValue = prices[i];
            } else {
                value = Math.max(value, prices[i] - minValue);
            }
        }
        return value;
    }
}
