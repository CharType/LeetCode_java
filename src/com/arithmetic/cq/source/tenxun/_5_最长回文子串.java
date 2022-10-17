package com.arithmetic.cq.source.tenxun;

/**
 * dp[i][j] 以i开始,已j结尾的字符串是否是回文串
 * dp[i][j] = dp[i+1][j-1] == true && chars[i] == chars[j]
 */
public class _5_最长回文子串 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        char[] chars = s.toCharArray();
        boolean[][] dp = new boolean[chars.length][chars.length];
        int li = 0;
        int max = 0;
        for (int i = chars.length; i >= 0; i--) {
            for (int j = i; j < chars.length; j++) {
                int len = j - i + 1;
                dp[i][j] = chars[i] == chars[j] && (len <= 2 || dp[i + 1][j - 1]);
                if (dp[i][j] && len > max) {
                    max = len;
                    li = i;
                }
            }
        }

        return new String(chars, li, max);
    }

    // 扩展中心法
    public String longestPalindrome2(String s) {
        if (s == null) return s;
        char[] chars = s.toCharArray();
        if (chars.length <= 1) return s;
        int maxLength = 1;
        int begin = 0;
        int i = 0;
        while (i < chars.length) {
            int l = i - 1;
            int r = i;
            while (++r < chars.length && chars[r] == chars[i]) ;
            i = r;
            while (l >= 0 && r < chars.length && chars[l] == chars[r]) {
                l--;
                r++;
            }
            int len = r - l - 1;
            if (len > maxLength) {
                maxLength = len;
                begin = l + 1;
            }
        }
        return new String(chars, begin, maxLength);
    }

    public static void main(String[] args) {
        _5_最长回文子串 o = new _5_最长回文子串();
        System.out.println(o.longestPalindrome("babad"));
    }
}
