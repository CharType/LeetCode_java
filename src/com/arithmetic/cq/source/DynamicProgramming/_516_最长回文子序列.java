package com.arithmetic.cq.source.DynamicProgramming;

/**
 * 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
 * <p>
 * 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "bbbab"
 * 输出：4
 * 解释：一个可能的最长回文子序列为 "bbbb" 。
 * 示例 2：
 * <p>
 * 输入：s = "cbbd"
 * 输出：2
 * 解释：一个可能的最长回文子序列为 "bb"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-subsequence
 * dp[i][j] 表示 已i开始 已 j 结束的字符串 的最长回文子序列的长度
 * chars[i] == chars[j]  dp[i+1][j-1] + 2
 * chars[i] != chars[j] dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
 */
public class _516_最长回文子序列 {

    static int longestPalindromeSubseq(String s) {
        if (s == null) return 0;
        char[] chars = s.toCharArray();
        if (chars.length == 0) return 0;
        if (chars.length == 1) return 1;
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
        return dp[0][chars.length - 1];
    }

    public static void main(String[] args) {
//        System.out.println(longestPalindromeSubseq("abba"));
        System.out.println(longestPalindromeSubseq("aaa"));
    }
}
