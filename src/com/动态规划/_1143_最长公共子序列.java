package com.动态规划;

/**
 * https://leetcode-cn.com/problems/longest-common-subsequence/
 */
public class _1143_最长公共子序列 {
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0) return 0;
        char [] text1Chars = text1.toCharArray();
        char [] text2Chars = text2.toCharArray();
        int [][] dp = new int[text1Chars.length][text2.length()];
        for (int i = 0; i < text1Chars.length;i++) {
           for (int j = 0;j < text2Chars.length;j++) {
               
           }
        }
        return 1;
    }

    public static void main(String[] args) {

    }
}
