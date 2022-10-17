package com.arithmetic.腾讯精选练习;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 状态转移方程
 * dp[i][j] 这个字符串中已开设 已j结尾的字符串是否是回文串
 *  chars[i] == chars[j] 当前字符串的开始和结尾相等 &&  当前字符串的长度<= 2 || dp[i + 1][j - 1] 当前字符串的子串也是回文串
 * dp[i][j] = (chars[i] == chars[j] && (len <= 2 || dp[i + 1][j - 1]));
 */
public class _5_最长回文子串 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return null;
        char [] chars = s.toCharArray();
        if (chars.length == 0) return "";
        boolean [][] dp = new boolean[s.length()][s.length()];

        int begin = 0;
        int maxLength = 0;
        for (int i = chars.length;i >=0;i--) {
            for (int j= i; j < chars.length;j++) {
                int len = j - i + 1;
                dp[i][j] = (chars[i] == chars[j] && (len <= 2 || dp[i + 1][j - 1]));
                if (dp[i][j] && len > maxLength) {
                    maxLength = len;
                    begin = i;
                }
            }
        }


        return new String(chars,begin,maxLength);
    }

    public static void main(String[] args) {
        _5_最长回文子串 o = new _5_最长回文子串();
        System.out.printf(o.longestPalindrome("babad"));

    }
}
