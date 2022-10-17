package com.arithmetic.cq.source.DynamicProgramming;

public class 最长公共子串 {
    public static void main(String[] args) {
        System.out.println(lcSubStr("AB", "BA"));
        System.out.println(lcSubStr1("AB", "BA"));
    }

    static int lcSubStr1(String text1, String text2) {
        if (text1 == null || text2 == null) return 0;
        char[] chars1 = text1.toCharArray();
        if (chars1.length == 0) return 0;
        char[] chars2 = text2.toCharArray();
        if (chars2.length == 0) return 0;
        char[] rowsChars = chars1;
        char[] colsChars = chars2;
        if (chars1.length < chars2.length) {
            rowsChars = chars2;
            colsChars = chars1;
        }
        int[] dp = new int[colsChars.length + 1];
        int maxLength = 0;
        for (int i = 1; i <= rowsChars.length; i++) {
            int cur = 0;
            for (int j = 1; j <= colsChars.length; j++) {
                int leftTop = cur;
                cur = dp[j - 1];
                if (rowsChars[i - 1] == colsChars[j - 1]) {
                    dp[j] = leftTop + 1;
                    maxLength = Math.max(maxLength, dp[j]);
                } else {
                    dp[j] = 0;
                }
            }
        }
        return maxLength;
    }

    static int lcSubStr(String text1, String text2) {
        if (text1 == null || text2 == null) return 0;
        char[] chars1 = text1.toCharArray();
        if (chars1.length == 0) return 0;
        char[] chars2 = text2.toCharArray();
        if (chars2.length == 0) return 0;

        int[][] dp = new int[chars1.length + 1][chars2.length + 1];
        int maxLength = 0;
        for (int i = 1; i <= chars1.length; i++) {
            for (int j = 1; j <= chars2.length; j++) {
                if (chars1[i - 1] == chars2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxLength = Math.max(maxLength, dp[i][j]);
                }
            }
        }
        return maxLength;
    }
}
