package com.arithmetic.精选Top面试题.简单;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 */
public class _121_买卖股票的最佳时机 {
    public int maxProfit1(int[] prices) {
        if (prices == null) return 0;
        if (prices.length <=1) return 0;

        int [] nums = new int[prices.length];
        nums[0] = 0;
        int maxPrice = 0;
        int minPrice = prices[0];
        for (int i = 1;i<prices.length;i++) {
            if (prices[i] > minPrice) {
                if ((prices[i] - minPrice) > maxPrice) {
                    nums[i] = (prices[i] - minPrice);
                } else {
                    nums[i] = nums[i-1];
                }
                maxPrice = Math.max(maxPrice,nums[i]);

            } else {
                nums[i] = nums[i-1];
            }
            minPrice = Math.min(minPrice,prices[i]);
        }
        return maxPrice;
    }

    public int maxProfit(int[] prices) {
        int profile = 0;
        int miniPrice = Integer.MAX_VALUE;
        for (int i : prices) {
            if (i<miniPrice){
                miniPrice = i;
            }else {
                profile = Math.max(profile,i-miniPrice);
            }
        }
        return profile;
    }

    public static void main(String[] args) {
        _121_买卖股票的最佳时机 o = new _121_买卖股票的最佳时机();
        int[] prices = {7,1,5,3,6,4};
        System.out.println(o.maxProfit(prices));
    }
}
