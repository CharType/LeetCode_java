package com.探索.快手;

/**
 *
 *  * 动态规划题目
 *  * 定义dp  dp(i，j)表示从i开始 到j结尾，这个字符串是否是一个回文字串
 *  * i-j+1 是字符串的长度  如果长度<=2 那么第i个字符和第j个字符相等，它就是一个最长回文字串
 *  * dp(i,j) = dp(i+1,j-1) && str[i] == str[j];
 *  *      0 1 2 3 4 5
 *  *        b a b a b
 *  * 0
 *  * 1 b    T F T F T
 *  * 2 a      T F T F
 *  * 3 b        T F T
 *  * 4 a          T F
 *  * 5 b            T
 *  *
 *  * dp(3,5) = dp[4,4] && (str[3] == str[5])
 *  * 所以要先从下往上遍历
 *  * 从左往右遍历
 */
public class _5_最长回文子串 {

    public String longestPalindrome(String s) {
        if (s == null) return s;
        char [] chars = s.toCharArray();
        if (chars.length == 0) return "";
        int li = 0;
        int maxLen = 0;
        boolean [][] dp = new boolean[chars.length][chars.length];
        for (int i = chars.length;i>= 0;i--) {
            for (int j = i;j < chars.length;j++) {
                int len = j - i + 1;
                dp[i][j] = chars[i] == chars[j] && (len <= 2 || dp[i+1][j-1]);
                if (dp[i][j] && len > maxLen) {
                    maxLen = len;
                    li = i;
                }
            }
        }
        return new String(chars,li,maxLen);
    }

    public static void main(String[] args) {
        _5_最长回文子串 o = new _5_最长回文子串();
        System.out.println(o.longestPalindrome("babad"));
    }
}
