package com.arithmetic.cq.source.DynamicProgramming;

import com.arithmetic.tools.Integers;

/**
 * dp[i][j] 最大承重为j 并且有前i件物品可选时候背包的最大价值
 */
public class 背包_01 {
    public static void main(String[] args) {
        int[] values = {6, 3, 5, 4, 6};
        int[] weights = {2, 2, 6, 5, 4};
        int capacity = 10;
        System.out.println(maxValue3(values, weights, capacity));
        System.out.println(maxValue2(values, weights, capacity));
    }

    /**
     * @param values
     * @param widgets
     * @param capacity
     * @return 返回-1 表示没有办法正好凑够capacity这个容量
     */
    static int maxValue3(int[] values, int[] widgets, int capacity) {
        if (values == null || values.length == 0) return 0;
        if (widgets == null || widgets.length == 0) return 0;
        if (values.length != widgets.length || capacity <= 0) return 0;
        int[] dp = new int[capacity + 1];
        for (int j = 1; j <= capacity; j++) {
            dp[j] = Integer.MIN_VALUE;
        }

        for (int i = 1; i <= values.length; i++) {
            for (int j = capacity; j >= widgets[i - 1]; j--) {
                dp[j] = Math.max(dp[j], values[i - 1] + dp[j - widgets[i - 1]]);
            }
        }
        return dp[capacity] < 0 ? -1 : dp[capacity];
    }

    static int maxValue2(int[] values, int[] widgets, int capacity) {
        if (values == null || values.length == 0) return 0;
        if (widgets == null || widgets.length == 0) return 0;
        if (values.length != widgets.length || capacity <= 0) return 0;
        int[] dp = new int[capacity + 1];
        for (int i = 1; i <= values.length; i++) {
            for (int j = capacity; j >= widgets[i - 1]; j--) {
                dp[j] = Math.max(dp[j], values[i - 1] + dp[j - widgets[i - 1]]);
            }
        }
        return dp[capacity];
    }

    static int maxValue1(int[] values, int[] widgets, int capacity) {
        if (values == null || values.length == 0) return 0;
        if (widgets == null || widgets.length == 0) return 0;
        if (values.length != widgets.length || capacity <= 0) return 0;
        int[] dp = new int[capacity + 1];
        for (int i = 1; i <= values.length; i++) {
            for (int j = capacity; j >= 1; j--) {
                if (j >= widgets[i - 1]) {
                    dp[j] = Math.max(dp[j], values[i - 1] + dp[j - widgets[i - 1]]);
                }
            }
        }
        return dp[capacity];
    }

    static int maxValue(int[] values, int[] widgets, int capacity) {
        if (values == null || values.length == 0) return 0;
        if (widgets == null || widgets.length == 0) return 0;
        if (values.length != widgets.length || capacity <= 0) return 0;
        int[][] dp = new int[values.length + 1][capacity + 1];
        for (int i = 1; i <= values.length; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (j < widgets[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], values[i - 1] + dp[i - 1][j - widgets[i - 1]]);
                }
            }
        }
        printf(dp);
        return dp[values.length][capacity];
    }

    static void printf(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            Integers.println(dp[i]);

        }
    }
}
