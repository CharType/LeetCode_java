package com.精选Top面试题.简单;

import com.tools.Times;

import java.math.BigInteger;

public class _172_阶乘后的零 {
    public int trailingZeroes(int n) {
        if (n == 0) return 1;
        BigInteger sum = BigInteger.ONE;
        for (int i = 1; i <= n;i++) {
            sum = sum.multiply(BigInteger.valueOf(i));
        }

        int count = 0;
        while (sum.mod(BigInteger.TEN).equals(BigInteger.ZERO)) {
            sum = sum.divide(BigInteger.TEN);
            count++;
        }
        return count;
    }

    public int trailingZeroes1(int n) {
        int zeroCount = 0;
        long currentMultiple = 5;
        while (n >= currentMultiple) {
            zeroCount += (n / currentMultiple);
            currentMultiple *= 5;
        }
        return zeroCount;
    }

    public static void main(String[] args) {
        _172_阶乘后的零 o = new _172_阶乘后的零();


       Times.test("第一种方式计算", new Times.Task() {
           @Override
           public void execute() {
               System.out.println(o.trailingZeroes(200));
           }
       });

        Times.test("第二种方式计算", new Times.Task() {
            @Override
            public void execute() {
                System.out.println(o.trailingZeroes1(200));
            }
        });

    }
}
