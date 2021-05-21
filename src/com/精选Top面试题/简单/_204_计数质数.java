package com.精选Top面试题.简单;

import java.awt.peer.ListPeer;

/**
 * 统计所有小于非负整数 n 的质数的数量。
 *
 * 示例:
 *
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * https://leetcode-cn.com/problems/count-primes/
 */
public class _204_计数质数 {

    public int countPrimes(int n) {
        // 记录哪些数是质数
        int count = 0;
        for (int i = 1;i< n;i++) {
            if (isPrimes(i)) count++;
        }
        return count;
    }

    public boolean isPrimes (int n) {
        if (n <= 3) return n > 1;
        for (int i = 2; i * i <= n;i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        _204_计数质数 o = new _204_计数质数();
        System.out.println(o.countPrimes(499979));
    }
}
