package com.arithmetic.头条高频算法题;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 */
public class _5_最长回文子串 {

    // 扩展中心法
    public String longestPalindrome1(String s) {
        if (s == null) return "";
        if (s.length() <=1) return s;
        char [] chars = s.toCharArray();

        int begin = 0;
        int maxLengtn = 1;

        for (int i = chars.length - 2;i >= 1 ; i--) {
            int leftLen = palindromeLength(chars,i - 1,i + 1);
            int rightLen = palindromeLength(chars,i,i+1);
            int len = Math.max(leftLen,rightLen);
            if (len > maxLengtn) {
                maxLengtn = len;
                begin = i - ((maxLengtn - 1) >> 1);
            }
        }
        if (chars[0] == chars[1] && maxLengtn < 2) {
            maxLengtn = 2;
            begin = 0;
        }


        return new String(chars,begin,maxLengtn);
    }

    public int palindromeLength(char[] chars,int l,int r) {
        while (l >= 0 && r < chars.length && chars[l] == chars[r]) {
            r++;
            l--;
        }
        return r - l - 1;
    }

    // 动态规划法
    public String longestPalindrome(String s) {
        if (s == null) return "";
        char [] chars = s.toCharArray();
        if (chars.length <=1) return s;
        int [][] dp = new int[chars.length][chars.length];
        //dp[i][j]表示 以i开头 已j结尾的字符串是否是最长回文字串
        return "";

    }

    public static void main(String[] args) {
        _5_最长回文子串 o = new _5_最长回文子串();
        System.out.println(o.longestPalindrome("abccb"));
    }
}
