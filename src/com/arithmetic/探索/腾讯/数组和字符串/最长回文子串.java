package com.arithmetic.探索.腾讯.数组和字符串;

/**
 * https://leetcode-cn.com/explore/interview/card/tencent/221/array-and-strings/896/
 */
public class 最长回文子串 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) return s;
        char [] chars = s.toCharArray();
        boolean [][] dp = new boolean[chars.length][chars.length];
        int begin = 0;
        int maxLen = 1;
        for (int i = chars.length-1;i >= 0;i--) {
            for (int j = i;j < chars.length;j++) {
                int len = j - i + 1;
                dp[i][j] = ((chars[i] == chars[j]) && (len <= 2 || dp[i+1][j-1]));
                if (dp[i][j] && len > maxLen) {
                    begin = i;
                    maxLen = len;
                }
            }
        }
        return new String(chars,begin,maxLen);
    }

    public String longestPalindrome2(String s) {
        if (s == null) return null;
        char[] cs = s.toCharArray();
        if (cs.length <= 1) return s;
        // 最长回文子串的长度（至少是1）
        int maxLen = 1;
        // 最长回文子串的开始索引
        int begin = 0;
        boolean[][] dp = new boolean[cs.length][cs.length];
        // 从下到上（i由大到小）
        for (int i = cs.length - 1; i >= 0; i--) {
            // 从左到右（j由小到大）
            for (int j = i; j < cs.length; j++) {
                // cs[i, j]的长度
                int len = j - i + 1;
                dp[i][j] = (cs[i] == cs[j]) && (len <= 2 || dp[i + 1][j - 1]);
                if (dp[i][j] && len > maxLen) { // 说明cs[i, j]是回文子串
                    maxLen = len;
                    begin = i;
                }
            }
        }
        return new String(cs, begin, maxLen);
    }

    public static void main(String[] args) {
        最长回文子串 o = new 最长回文子串();
        System.out.println(o.longestPalindrome("babad"));
    }
}
