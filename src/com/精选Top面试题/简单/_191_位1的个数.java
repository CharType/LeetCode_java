package com.精选Top面试题.简单;

/**
 * https://leetcode-cn.com/problems/number-of-1-bits/
 */
public class _191_位1的个数 {
    public int hammingWeight(int n) {
//        String s = Integer.toBinaryString(n);
        int sum = 0;
        for (int i = 0;i < 32;i++) {
             sum += (n >> i & 0x01);
        }
        return sum;
    }

    public int hammingWeight1(int n) {
        String s = Integer.toBinaryString(n);
        char [] chars = s.toCharArray();
        int sum = 0;
        for (char c:chars) {
            if (c == '1') {
                sum += 1;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        _191_位1的个数 o = new _191_位1的个数();
        System.out.println(Integer.toBinaryString(100));
        System.out.println(o.hammingWeight(100));
    }
}
