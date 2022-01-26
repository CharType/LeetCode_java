package com.arithmetic.cq.source.tenxun;

import com.arithmetic.tools.Asserts;

public class _9_回文数 {

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x < 10) return true;
        int res = reverse(x);
        return res == x;
    }

    public int reverse(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return 0;
            x = x / 10;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        _9_回文数 o = new _9_回文数();
        Asserts.test(o.isPalindrome(121) == true);
        Asserts.test(o.isPalindrome(1221) == true);
        Asserts.test(o.isPalindrome(1213) == false);
        Asserts.test(o.isPalindrome(-121) == false);
    }
}
