package com.cq.source.recursive;

import com.tools.Times;
import com.tools.Times.Task;

public class Fib {
    public static void main(String[] args) {
        Fib f = new Fib();
        int n = 64;
//        Times.test("fib", new Task() {
//            @Override
//            public void execute() {
//                System.out.println(f.fib(n));
//            }
//        });

        Times.test("fib1", new Task() {
            @Override
            public void execute() {
                System.out.println(f.fib1(n));
            }
        });

        Times.test("fib2", new Task() {
            @Override
            public void execute() {
                System.out.println(f.fib2(n));
            }
        });

        Times.test("fib3", new Task() {
            @Override
            public void execute() {
                System.out.println(f.fib3(n));
            }
        });

        Times.test("fib4", new Task() {
            @Override
            public void execute() {
                System.out.println(f.fib4(n));
            }
        });
        Times.test("fib5", new Task() {
            @Override
            public void execute() {
                System.out.println(f.fib5(n));
            }
        });
        Times.test("fib6", new Task() {
            @Override
            public void execute() {
                System.out.println(f.flb6(n));
            }
        });
    }

    public int fib(int n) {
        if (n <= 2) return 1;
        return fib(n - 1) + fib(n - 2);
    }

    public int fib1(int n) {
        if (n <= 2) return 1;
        int[] array = new int[n + 1];
        array[1] = array[2] = 1;
        for (int i = 3; i <= n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n];
    }

    public int fib2(int n) {
        if (n <= 2) return 1;
        int[] array = new int[2];
        array[0] = array[1] = 1;
        for (int i = 3; i <= n; i++) {
            array[i % 2] = array[0] + array[1];
        }
        return array[n % 2];
    }

    public int fib3(int n) {
        if (n <= 2) return 1;
        int[] array = new int[2];
        array[0] = array[1] = 1;
        for (int i = 3; i <= n; i++) {
            array[i & 1] = array[0] + array[1];
        }
        return array[n & 1];
    }

    public int fib4(int n) {
        if (n <= 2) return 1;
        int first = 1;
        int second = 1;
        for (int i = 3; i <= n; i++) {
            second = first + second;
            first = second - first;
        }
        return second;
    }

    public int fib5(int n) {
        double c = Math.sqrt(5);

        return (int) ((Math.pow((1 + c) / 2, n) - Math.pow((1 - c) / 2, n)) / c);
    }

    public int flb6(int n) {
        if (n == 0) return 0;
        if (n <= 2) return 1;
        double sqrt5 = Math.sqrt(5);
        double result = 1 / sqrt5 * (Math.pow((1 + sqrt5) / 2, n) - Math.pow((1 - sqrt5) / 2, n));
        return (int) Math.round(result);

    }
}
