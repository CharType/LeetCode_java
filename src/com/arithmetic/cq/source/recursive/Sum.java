package com.arithmetic.cq.source.recursive;

import com.arithmetic.tools.Times;

// 求和的几种方式
public class Sum {
    public static void main(String[] args) {
        int n = 10000;
        Times.test("sum", new Times.Task() {
            @Override
            public void execute() {
                System.out.println(sum(n));
            }
        });
        Times.test("sum1", new Times.Task() {
            @Override
            public void execute() {
                System.out.println(sum1(n));
            }
        });
        Times.test("sum3", new Times.Task() {
            @Override
            public void execute() {
                System.out.println(sum3(n));
            }
        });
    }

    public static int sum(int n) {
        if (n <= 1) return n;
        return n + sum(n - 1);
    }

    public static int sum1(int n) {
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static int sum3(int n) {
        if (n <= 1) return n;
        return (1 + n) * n / 2;
    }
}
