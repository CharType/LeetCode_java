package com.每日一题;

/**
 * https://leetcode-cn.com/problems/palindrome-number/
 */
public class _9_回文数 {
    public boolean isPalindrome(int x) {
        char [] chars = Integer.toString(x).toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean isPalindrome2(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x = x / 10;
        }

        return x == revertedNumber || x == revertedNumber / 10;
    }

    public static void main(String[] args) {
        _9_回文数 o = new  _9_回文数();
        System.out.println(o.isPalindrome2(1221));
    }
}
