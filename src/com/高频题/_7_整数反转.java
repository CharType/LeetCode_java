package com.高频题;

public class _7_整数反转 {

    public int reverse(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return 0;
            x /= 10;
        }
        return (int)res;
    }

    public int reverse1(int x) {
        int res = 0;
        while (x != 0) {
            int prevRes = res;
            int mod = x % 10;
            res = prevRes * 10 + mod;
            if ((res - (mod)) / 10 != prevRes) return 0;

            x /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        _7_整数反转 o = new _7_整数反转();
        System.out.println(o.reverse1(2100));

    }
}
