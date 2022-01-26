package com.arithmetic.每日一题;

/**
 * https://leetcode-cn.com/problems/qiu-12n-lcof/
 */
public class _面试题64_求1加到n {

    public int sumNums(int n) {
        return n == 0 ? 0 : n + sumNums(n - 1);
    }

    public static void main(String[] args) {
        _面试题64_求1加到n o = new _面试题64_求1加到n();
        System.out.println(o.sumNums(3));
    }
}
