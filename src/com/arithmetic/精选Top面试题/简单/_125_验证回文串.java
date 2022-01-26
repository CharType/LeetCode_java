package com.arithmetic.精选Top面试题.简单;

/**
 *https://leetcode-cn.com/problems/valid-palindrome/
 */
public class _125_验证回文串 {
    public boolean isPalindrome(String s) {
        if (s == null) return false;
        char [] chars = s.toCharArray();
        if (chars.length == 0 || chars.length == 1) return  true;
        int rightIndex = chars.length - 1;
        int leftIndex = 0;
        while (leftIndex < rightIndex) {
            while (!Character.isLetterOrDigit(chars[leftIndex]) && leftIndex < rightIndex) {
                leftIndex++;
            }
            while (!Character.isLetterOrDigit(chars[rightIndex]) && leftIndex < rightIndex) {
                rightIndex--;
            }
            // 如果不相等，就返回false
            if ((int) Character.toLowerCase(chars[leftIndex]) != (int) Character.toLowerCase(chars[rightIndex])) {
                return false;
            }

            // 将i和j向中间移动
            leftIndex++; rightIndex--;
        }
        return true;
    }


    public static void main(String[] args) {
        _125_验证回文串 o = new _125_验证回文串();
        System.out.println(o.isPalindrome("A man, a plan, a canal: Panama"));
    }
}
