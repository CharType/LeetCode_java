package com.探索.快手;

import com.tools.Integers;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-subsequence/
 */
public class _516_最长回文子序列 {

    public int longestPalindromeSubseq(String s) {
        if (s == null) return 0;
        char[] chars = s.toCharArray();
        if (chars.length <= 1) return chars.length;
        int[][] dp = new int[chars.length][chars.length];
        for (int i = chars.length - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        for (int[] nums : dp) {
            Integers.println(nums);
        }
        return dp[0][chars.length - 1];

    }

    public int longestPalindromeSubseq1(String s) {
        int n = s.length();
        int[][] f = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            f[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    f[i][j] = f[i + 1][j - 1] + 2;
                } else {
                    f[i][j] = Math.max(f[i + 1][j], f[i][j - 1]);
                }
            }
        }
        return f[0][n - 1];
    }

    public static void main(String[] args) {
        _516_最长回文子序列 o = new _516_最长回文子序列();
        System.out.println(o.longestPalindromeSubseq1("cbbc"));
    }
}
