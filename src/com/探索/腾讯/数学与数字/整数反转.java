package com.探索.腾讯.数学与数字;

import com.tools.Asserts;

/**
 * https://leetcode-cn.com/explore/interview/card/tencent/223/math-and-numbers/938/
 */
public class 整数反转 {
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
        整数反转 o = new  整数反转();
        Asserts.test(o.reverse(123) == 321);
        Asserts.test(o.reverse(-123) == -321);
        Asserts.test(o.reverse(123987) == 789321);
    }
}
