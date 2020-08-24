package com.动态规划;

/**
 * https://leetcode-cn.com/problems/longest-common-subsequence/
 */
public class _1143_最长公共子序列 {
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0) return 0;
        char [] text1Chars = text1.toCharArray();
        char [] text2Chars = text2.toCharArray();
        int [][] dp = new int[text1Chars.length + 1][text2Chars.length + 1];
        for (int i = 1; i <= text1Chars.length;i++) {
           for (int j = 1;j <= text2Chars.length;j++) {
                if (text1Chars[i -1] == text2Chars[j - 1]) {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]) + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
           }
        }
        return dp[text1Chars.length][text2Chars.length];
    }

    public static void main(String[] args) {
//        String str1 = "abcde";
//        String str2 = "ace";
        String str1 = "bsbininm";
        String str2 = "jmjkbkjkv";
        _1143_最长公共子序列 o = new _1143_最长公共子序列();
        System.out.println(o.longestCommonSubsequence(str1,str2));
    }
}
