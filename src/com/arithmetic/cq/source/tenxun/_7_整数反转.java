package com.arithmetic.cq.source.tenxun;

public class _7_整数反转 {
    public int reverse(int x) {
        if (x < 10 && x >= 0) return x;
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return 0;
            x = x / 10;
        }

        return (int) res;
    }

    public static void main(String[] args) {
        _7_整数反转 o = new _7_整数反转();
        System.out.println(o.reverse(2100));
    }
}
