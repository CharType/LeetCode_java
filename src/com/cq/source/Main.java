package com.cq.source;

//import java.util.LinkedList;
//import java.util.List;

import com.cq.source.array.ArrayList;
import com.cq.source.circle.EnhanceSingleCircleLinkList;
import com.tools.Asserts;

public class Main {

    public static void testList(List<Integer> list) {
        list.add(11);
        list.add(22);
        list.add(33);
        list.add(44);

        list.add(0, 55); // [55, 11, 22, 33, 44]
        list.add(2, 66); // [55, 11, 66, 22, 33, 44]
        list.add(list.size(), 77); // [55, 11, 66, 22, 33, 44, 77]


        list.remove(0); // [11, 66, 22, 33, 44, 77]
        list.remove(2); // [11, 66, 33, 44, 77]
        list.remove(list.size() - 1); // [11, 66, 33, 44]


        Asserts.test(list.indexOf(44) == 3);
        Asserts.test(list.indexOf(22) == List.ELEMENT_NOT_FOUND);
        Asserts.test(list.contains(33));
        Asserts.test(list.get(0) == 11);
        Asserts.test(list.get(1) == 66);
        Asserts.test(list.get(list.size() - 1) == 44);

        System.out.println(list);

    }

    public static void main(String[] args) {

        //testList(new LinkedList<>());
//        testList(new SingleLinkList<>());
//        testList(new SingleCircleLinkList<>());
//        testList(new CircleLinkedList<>());
//        testList(new EnhanceSingleCircleLinkList<>());
//        testList(new EnhanceCircleLinkedList<>());
//        testList(new ArrayList<>());
//        System.out.println(123);

        ArrayList<Integer> array = new ArrayList<>(10);
        for (int i = 0; i < 1000; i++) {
            array.add(i);
        }

        System.out.println(array);

        for (int i = 999; i > 0; i--) {
            if (i % 2 == 0) {
                array.remove(i);
            }
        }
        System.out.println(array);

//        josephusProblem();
    }

    /**
     * 约瑟夫问题
     */
    public static void josephusProblem() {
        EnhanceSingleCircleLinkList<Integer> list = new EnhanceSingleCircleLinkList<>();
        for (int i = 1; i <= 8; i++) {
            list.add(i);
        }
        System.out.println(list);

        list.reset();
        while (list.isEmpty() == false) {
            list.next();
            list.next();
            System.out.println("第" + list.remove() + "个人被杀死了");
            System.out.println("还有" + list.size() + "个元素");
        }

    }
}
