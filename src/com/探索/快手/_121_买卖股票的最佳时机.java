package com.探索.快手;

public class _121_买卖股票的最佳时机 {
    public int maxProfit(int[] prices) {
        if (prices == null) return 0;
        // 记录之前的最小值
        int min = Integer.MAX_VALUE;
        // 记录最大的差
        int value = 0;
        for (int num:prices) {
            if (num < min) {
                min = num;
            } else {
                value = Math.max(value,num - min);
            }
        }
        return value;

    }

    public static void main(String[] args) {
        _121_买卖股票的最佳时机 o = new _121_买卖股票的最佳时机();
        int [] nums = {7,1,5,3,6,4};
        System.out.println(o.maxProfit(nums));
    }
}
