package com.arithmetic.高频题;

/**
 * https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/
 * f(n,m) = (f(n - 1,m) + m) % n;
 */
public class _面试题62_圆圈中最后剩下的数字 {
    public int lastRemaining(int n, int m) {
        if (n < 1) return -1;
        if (n == 1) return 0;
        return (lastRemaining(n -1,m) + m) % n;
    }

    public int lastRemaining2(int n, int m) {
        int res = 0;
        for (int i = 2; i<= n; i++) {
            res = (res + m) % i;
        }
        return res;
    }

    public static void main(String[] args) {
        _面试题62_圆圈中最后剩下的数字 o = new _面试题62_圆圈中最后剩下的数字();
        System.out.println(o.lastRemaining2(10,17));

    }
}
