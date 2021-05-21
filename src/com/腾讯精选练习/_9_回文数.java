package com.腾讯精选练习;

/**
 * https://leetcode-cn.com/problems/palindrome-number/
 * 9. 回文数
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 */
public class _9_回文数 {

    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int reverseNum = reverse(x);
        return x == reverseNum || x == reverseNum / 10;
    }

    public int reverse(int x) {
        long reversNumber = 0;
        while (x != 0) {
            reversNumber = reversNumber * 10 + x % 10;
            if (reversNumber > Integer.MAX_VALUE || reversNumber < Integer.MIN_VALUE) {
                return 0;
            }
            x /= 10;
        }
        return (int)reversNumber;
    }

    public static void main(String[] args) {
        _9_回文数 o = new _9_回文数();
        System.out.println(o.isPalindrome(1221));
    }
}
