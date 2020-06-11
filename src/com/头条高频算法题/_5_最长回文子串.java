package com.头条高频算法题;

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
        if (s.length() <=1) return s;
        char [] chars = s.toCharArray();
        // do[i][j] 表示从i开始到j结束的字符串是不是回文字符串
        boolean [][] dp = new  boolean[chars.length][chars.length];
        int begin = 0;
        int maxLengtn = 1;
        // 从小到大，i由大到小比较
        for (int i = chars.length - 1;i >= 0;i--) {
            // 从左到右，j 由小变大
            for (int j = i;j<chars.length;j++) {
                // 计算出当前字符的长度
                int len = j - i + 1;
                dp[i][j] = (chars[i] == chars[j]) && (len <= 2 || dp[i + 1][j - 1]);
                if (dp[i][j] && len > maxLengtn) {
                    maxLengtn = len;
                    begin = i;
                }
            }
        }
        return new String(chars,begin,maxLengtn);
    }

    public static void main(String[] args) {
        _5_最长回文子串 o = new _5_最长回文子串();
        System.out.println(o.longestPalindrome1("abccb"));
    }
}
