package com.动态规划;

import com.tools.Integers;

/**
 * https://leetcode-cn.com/problems/coin-change/
 */
public class _322_零钱兑换 {
    public int coinChange(int[] coins, int amount) {
       if (amount < 0) return -1;
       if (amount == 0) return 0;
       int [] dp = new int[amount + 1];
       for (int i = 1;i<= amount;i++) {
           int min = Integer.MAX_VALUE;
           for (int j = 0;j < coins.length;j++) {
               if (i < coins[j] || dp[i - coins[j]] == -1) continue;
               if (i >= coins[j]) min = Math.min(min,dp[i - coins[j]]);
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
        _322_零钱兑换 o = new _322_零钱兑换();
        int [] coins = {1,2,5};
        System.out.println(o.coinChange(coins,11));
    }
}
