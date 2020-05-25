package com.高频题;

/**
 * https://leetcode-cn.com/problems/powx-n/
 */
public class _50_Pow {

    // 非递归版本
    public double myPow3(double x, int n) {
        if (n == 0) return 1;
        if (n == -1) return 1/x;
        double half = myPow(x, n>>1);
        half *= half;
        return (n & 1) == 1 ? (half * x) : half;
    }

    // 递归 位移
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == -1) return 1/x;
        double half = myPow(x, n>>1);
        half *= half;
        return (n & 1) == 1 ? (half * x) : half;
    }

    // 递归，除法
    public double myPow2(double x, int n) {
        if (n == 0) return 1;
        double half = myPow(x, n/2);
        half *= half;
        return (n & 1) == 1 ? (half * x) : half;
    }

    // 错误的解法
    public double myPow1(double x, int n) {
        double result = 1;
        if (n > 0) {
            while (n > 0) {
                result *= x;
                n--;
            }
        } else {
            while (n < 0) {
                result *= x;
                n++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        _50_Pow o = new _50_Pow();
        System.out.println(o.myPow(20000,-2));
    }
}
