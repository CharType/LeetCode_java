package com.精选Top面试题.中等;

/**
 * https://leetcode-cn.com/problems/decode-ways/
 * dp[i] 以s[i]结尾的前缀字符串有多少种解码的方法
 * if(s[i] != '0') dp[i] = dp[i-1] * 1
 *
 *
 */
public class _91_解码方法 {

    public int numDecodings(String s) {
        int len = s.length();
        if (len == 0) return 0;
        // 定义状态 dp[i] = 以i结尾的字符串有多少种编码方法
        int [] dp = new int[len];
        char [] chars = s.toCharArray();
        // 要注意判断字母是不是0的情况
        if (chars[0] == '0') return 0;
        // 第一个字母只有一种编码方法
        dp[0] = 1;
        for (int i = 1;i < len;i++) {
            if (chars[i] != '0') {
                //如果当前字符不是0 先等于之前的编码方法
                dp[i] = dp[i-1];
            }
            // 计算出当前数和之前的数
            int num = 10 * (chars[i - 1] - '0') + (chars[i] - '0');
            // 如果数字大于等于10 小于等于26
            if (num >= 10 && num <= 26) {
                if (i == 1) {
                    // 如果是第一个数 直接++
                    dp[i]++;
                } else {
                    // 如果不是第一个数 等于当前数+ i-2对应的数据
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[len - 1];
    }

    public static void main(String[] args) {
        _91_解码方法 o = new _91_解码方法();
        String s = "1526";
        int res = o.numDecodings(s);
        System.out.println(res);
    }
}
