package com.精选Top面试题.简单;

/**
 * https://leetcode-cn.com/problems/reverse-string/
 */
public class _344_反转字符串 {
    public void reverseString(char[] s) {
        if (s == null) return;
        int left = 0;
        int right = s.length-1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        _344_反转字符串 o = new _344_反转字符串();
        char [] s = {'h','e','l','l','o'};
        o.reverseString(s);
        System.out.println(s);
    }
}
