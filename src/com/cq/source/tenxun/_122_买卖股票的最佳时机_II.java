package com.cq.source.tenxun;

public class _122_买卖股票的最佳时机_II {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int preMine = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (preMine < prices[i]) {
                ans += prices[i] - preMine;
                preMine = prices[i];
            } else {
                preMine = prices[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        _122_买卖股票的最佳时机_II o = new _122_买卖股票的最佳时机_II();
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(o.maxProfit(nums));
    }
}
