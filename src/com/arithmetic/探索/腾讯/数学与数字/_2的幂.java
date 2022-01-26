package com.arithmetic.探索.腾讯.数学与数字;

/**
 * https://leetcode-cn.com/explore/interview/card/tencent/223/math-and-numbers/942/
 */
public class _2的幂 {
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
       _2的幂 o =  new _2的幂();
        System.out.println(o.isPowerOfTwo(16));
        System.out.println(o.isPowerOfTwo(19));
    }
}
