package com.精选Top面试题.简单;

/**
 * https://leetcode-cn.com/problems/power-of-three/
 */
public class _326_3的幂 {
    public boolean isPowerOfThree(int n) {
        if (n == 0) return false;
        if (n % 3 != 0) return false;

        while (n % 3 == 0) {
            n = n / 3;
        }
        return  n == 1;
    }

    public boolean isPowerOfThree1(int n) {
        if (n == 0) return false;
        if (n == 1) return true;
        if (n % 3 != 0) return n == 1;
        return isPowerOfThree1(n / 3);

    }

    public boolean isPowerOfThree3(int n) {
        return Integer.toString(n,3).matches("^10*$");

    }


    public static void main(String[] args) {
        _326_3的幂 o = new _326_3的幂();
        System.out.println(o.isPowerOfThree3(27));
    }
}
