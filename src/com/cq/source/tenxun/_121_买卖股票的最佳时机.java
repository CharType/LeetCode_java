package com.cq.source.tenxun;

public class _121_买卖股票的最佳时机 {
    public int maxProfit(int[] prices) {
        int preMinValue = prices[0];
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < preMinValue) {
                preMinValue = prices[i];
            } else {
                ans = Math.max(ans, prices[i] - preMinValue);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        _121_买卖股票的最佳时机 o = new _121_买卖股票的最佳时机();
        int[] prices = {7, 8, 5, 3, 6, 4};
        System.out.println(o.maxProfit(prices));
//        ss
    }
}
