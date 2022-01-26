package test;

import com.arithmetic.tools.Times;

public class CPU分支预测 {
    public static void main(String[] args) {
        Times.test("100-10000-100000", new Times.Task() {
            @Override
            public void execute() {
                for (int i = 0; i < 100; i++) {
                    for (int j = 0; j < 10000; j++) {
                        for (int k = 0; k < 10000000; k++) {

                        }
                    }
                }
            }
        });

        Times.test("100-10000-10000000", new Times.Task() {
            @Override
            public void execute() {
                int i = 0;
                for (; i < 100; i++) {
                    int j = 0;
                    for (; j < 10000; j++) {
                        int k = 0;
                        for (; k < 10000000; k++) {

                        }
                    }
                }
            }
        });
        System.out.println("---------------------------------");
        Times.test("100000-10000-100", new Times.Task() {
            @Override
            public void execute() {
                for (int i = 0; i < 100000; i++) {
                    for (int j = 0; j < 10000; j++) {
                        for (int k = 0; k < 100; k++) {

                        }
                    }
                }
            }
        });
        Times.test("100000-10000-100", new Times.Task() {
            @Override
            public void execute() {
                int i = 0;
                for (; i < 100000; i++) {
                    int j = 0;
                    for (; j < 10000; j++) {
                        int k = 0;
                        for (; k < 100; k++) {

                        }
                    }
                }
            }
        });
    }
}
