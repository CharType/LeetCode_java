package com.探索.头条.动态规划;

/**
 * https://leetcode-cn.com/problems/coin-change/
 */
public class _322_零钱兑换 {
    public int coinChange(int[] coins, int amount) {
       if (coins == null || coins.length == 0) return -1;
       if (amount < 0) return -1;
       if (amount == 0) return 0;
       int [] dp = new int [amount + 1];
       dp[0] = 0;
       for (int i = 1;i <dp.length;i++) {
           int mine = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i < coin || dp[i - coin] == -1) continue;
                if (i > coin) {
                    mine = Math.min(dp[i], 1 + dp[i-coin]);
                }
           }
            if (mine == Integer.MAX_VALUE) {
                dp[i] = -1;
            } else {
                dp[i] = mine + 1;
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
