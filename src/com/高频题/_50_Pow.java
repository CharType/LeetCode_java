package com.高频题;

/**
 * https://leetcode-cn.com/problems/powx-n/
 */
public class _50_Pow {
    public double myPow(double x, int n) {
        double result = 1;
        while (n > 0) {
            result *= x;
            n--;
        }
        return result;
    }

    public static void main(String[] args) {
        _50_Pow o = new _50_Pow();
        System.out.println(o.myPow(2,10));
    }
}
