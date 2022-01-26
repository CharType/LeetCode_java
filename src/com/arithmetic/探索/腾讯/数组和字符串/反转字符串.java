package com.arithmetic.探索.腾讯.数组和字符串;

/**
 * https://leetcode-cn.com/explore/interview/card/tencent/221/array-and-strings/905/
 */
public class 反转字符串 {
    public void reverseString(char[] s) {
        if (s == null || s.length <= 1) return;
        int li = 0,ri = s.length - 1;
        while (li < ri) {
            char c = s[li];
            s[li] = s[ri];
            s[ri] = c;
            li++;
            ri--;
        }
    }

    public static void main(String[] args) {
        反转字符串 o = new 反转字符串();
        char [] chars = {'H','a','n','n','a','h'};
        o.reverseString(chars);
        for (int i = 0;i < chars.length;i++) {
            System.out.println(chars[i]);
        }
    }
}
