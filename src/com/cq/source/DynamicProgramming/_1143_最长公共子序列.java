package com.cq.source.DynamicProgramming;

/**
 * 给定两个字符串text1 和text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 * <p>
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-subsequence
 * dp[i][j] 是第一个text前i个元素和第二个text前j个元素最长公共子序列的长度
 * dp[i][0] he dp[0][j] 的初始值都是0
 * 如果test1[i-1] == text2[j-1] 那么 dp[i][j] = dp[i-1][j-1] + 1;
 * 如果test1[i-1] != text2[j-1] 那么 dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
 */
public class _1143_最长公共子序列 {

    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null) return 0;
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();
        int ilength = chars1.length + 1;
        int jlength = chars2.length + 1;
        int[][] dp = new int[ilength][jlength];
        for (int i = 1; i < ilength; i++) {
            for (int j = 1; j < jlength; j++) {
                if (chars1[i - 1] == chars2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[ilength - 1][jlength - 1];
    }

    public static void main(String[] args) {

    }
}
