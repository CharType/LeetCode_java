package com.每日一题;


public class _2_的幂 {
    public boolean isPowerOfTwo(int n) {
        if (n == 0) return false;
        if (n == 1) return true;
        double k = n;
        while (k > 2.f) {
            k = k / 2.f;
        }
        return k == 2.f;
    }

    public static void main(String[] args) {
        _2_的幂 o = new _2_的幂();
        System.out.println(o.isPowerOfTwo(16));
        System.out.println(o.isPowerOfTwo(19));
    }
}
