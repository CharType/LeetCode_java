package com.arithmetic.探索.腾讯.数学与数字;

import com.arithmetic.tools.Asserts;

/**
 * https://leetcode-cn.com/explore/interview/card/tencent/223/math-and-numbers/939/
 */
public class 回文数 {

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int newx = reverse(x);
        return newx == x;
    }

    public int reverse(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + x  % 10;
            if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return 0;
            x = x /10;
        }
        return  (int)res;
    }

    public static void main(String[] args) {
        回文数 o = new 回文数();
        Asserts.test(o.isPalindrome(121) == true);
        Asserts.test(o.isPalindrome(1221) == true);
        Asserts.test(o.isPalindrome(1213) == false);
        Asserts.test(o.isPalindrome(-121) == false);
    }
}
