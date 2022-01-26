package com.arithmetic.other;

public class _72_编辑距离 {

    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) return 0;
        char [] word1chars = word1.toCharArray();
        char [] word2chars = word2.toCharArray();
        int [][] dp = new int[word1chars.length + 1][word2chars.length +1];
        dp[0][0] = 0;
        for (int i = 1;i <= word1chars.length;i++) {
            dp[i][0] = i;
        }

        for (int i = 1;i <= word2chars.length;i++) {
            dp[0][i] = i;
        }

        for (int i = 1;i <= word1chars.length;i++) {
            for (int j = 1;j <= word2chars.length;j++) {
                if (word1chars[i-1] == word2chars[j-1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j] + 1,dp[i][j-1] + 1),dp[i-1][j-1]+1);
                }
            }
        }
        return dp[word1chars.length][word2chars.length];
    }

    public static void main(String[] args) {
        _72_编辑距离 o = new _72_编辑距离();
        System.out.println(o.minDistance("horseajshdkadhka","rosksjdhkahjaksdaks"));
    }
}
