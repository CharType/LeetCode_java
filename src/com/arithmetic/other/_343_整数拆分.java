package com.arithmetic.other;

/**
 * https://leetcode-cn.com/problems/integer-break/
 */
public class _343_整数拆分 {

    /**
     *
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        // dp[i]= max{max(j×(i−j),j×dp[i−j])}

        int [] dp = new  int[n+1];
        for (int i = 2;i <= n;i++) {
            int curMax = 0;
            for (int j = 1;j < i;j++) {
                curMax = Math.max(curMax,Math.max(j * (i - j),j * dp[i - j]));
            }
            dp[i] = curMax;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        _343_整数拆分 o = new _343_整数拆分();
        System.out.println(o.integerBreak(10));
    }
}
