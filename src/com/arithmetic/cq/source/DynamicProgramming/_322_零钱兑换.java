package com.arithmetic.cq.source.DynamicProgramming;

/**
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * <p>
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回-1 。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 */
public class _322_零钱兑换 {
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        if (amount < 1 || coins == null || coins.length == 0) return -1;
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i < coins[j] || dp[i - coins[j]] < 0 || dp[i - coins[j]] >= min) continue;
                min = Integer.min(dp[i - coins[j]], min);
            }
            if (min == Integer.MAX_VALUE) {
                dp[i] = -1;
            } else {
                dp[i] = min + 1;
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
//        System.out.println(coins(41));
//        System.out.println(coins1(41));
//        System.out.println(coins2(41));
        _322_零钱兑换 o = new _322_零钱兑换();
//        int[] coins = {1, 5, 20, 25};
//        System.out.println(o.coinChange(coins, 41));
        int[] coins = {1};
        System.out.println(o.coinChange(coins, 0));
    }

    static int coins2(int n) {
        if (n < 1) return -1;
        int[] dp = new int[n + 1];
        int[] coins = new int[dp.length];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            if (i >= 1) {
                min = Integer.min(dp[i - 1], min);
                coins[i] = 1;
            }
            if (i >= 5) {
                min = Integer.min(dp[i - 5], min);
                coins[i] = 5;
            }
            if (i >= 20) {
                min = Integer.min(dp[i - 20], min);
                coins[i] = 20;
            }
            if (i >= 25) {
                min = Integer.min(dp[i - 25], min);
                coins[i] = 25;
            }
            dp[i] = min + 1;
        }
        print(coins);
        return dp[n];
    }

    static void print(int[] coins) {
        int index = coins.length - 1;
        while (index > 0) {
            System.out.print(coins[index] + "   ");
            index = index - coins[index];
        }
        System.out.println();
    }


    static int coins1(int n) {
        if (n < 1) return -1;
        int[] dp = new int[n + 1];
        int[] faces = {1, 5, 20, 25};
        for (int face : faces) {
            if (n < face) break;
            dp[face] = 1;
        }
        return coins1(n, dp);
    }

    static int coins1(int n, int[] dp) {
        if (n < 1) return Integer.MAX_VALUE;
        if (dp[n] == 0) {
            int min1 = Math.min(coins1(n - 25, dp), coins1(n - 20, dp));
            int min2 = Math.min(coins1(n - 5, dp), coins1(n - 1, dp));
            dp[n] = Math.min(min1, min2) + 1;
        }
        return dp[n];
    }

    /**
     * 暴力递归
     *
     * @param n
     * @return
     */
    static int coins(int n) {
        if (n < 1) return Integer.MAX_VALUE;
        if (n == 25 || n == 20 || n == 5 || n == 1) return 1;
        int min1 = Math.min(coins(n - 25), coins(n - 20));
        int min2 = Math.min(coins(n - 5), coins(n - 1));
        return Math.min(min1, min2) + 1;
    }
}
