package test;

import com.arithmetic.tools.Integers;
import com.arithmetic.tools.Times;

import java.util.ArrayList;

// 2 4 ...100/ 2 50
//4 8  //3 25
public class CPU分支预测 {
    public static void main(String[] args) {
        Integer [] integers = new Integer[100];
        ArrayList list = new ArrayList<Integer>();
        for (int i = 0;i <100;i++) {
            list.add(i+1);
        }
        int j = 1;
        while (list.size() !=1) {
            System.out.println("第"+j+"轮："+list.toString());
            int size = list.size();
            for (int i = size-1;i >=0 ;i--) {
                if((i + 1) % 2 == 1) {
                    list.remove(i);
                }
            }
            j++;
        }
        System.out.println(list.get(0));

//        Times.test("100-10000-100000", new Times.Task() {
//            @Override
//            public void execute() {
//                for (int i = 0; i < 100; i++) {
//                    for (int j = 0; j < 10000; j++) {
//                        for (int k = 0; k < 100000; k++) {
//
//                        }
//                    }
//                }
//            }
//        });

//        Times.test("100-10000-10000000", new Times.Task() {
//            @Override
//            public void execute() {
//                int i = 0;
//                for (; i < 100; i++) {
//                    int j = 0;
//                    for (; j < 10000; j++) {
//                        int k = 0;
//                        for (; k < 10000000; k++) {
//
//                        }
//                    }
//                }
//            }
//        });
//        System.out.println("---------------------------------");
//        Times.test("1000000-100000-100", new Times.Task() {
//            @Override
//            public void execute() {
//                for (int i = 0; i < 100000; i++) {
//                    for (int j = 0; j < 10000; j++) {
//                        for (int k = 0; k < 100; k++) {
//
//                        }
//                    }
//                }
//            }
//        });
//        Times.test("100000-10000-100", new Times.Task() {
//            @Override
//            public void execute() {
//                int i = 0;
//                for (; i < 100000; i++) {
//                    int j = 0;
//                    for (; j < 10000; j++) {
//                        int k = 0;
//                        for (; k < 100; k++) {
//
//                        }
//                    }
//                }
//            }
//        });
    }
}
