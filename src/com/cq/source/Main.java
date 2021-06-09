package com.cq.source;

//import java.util.LinkedList;
//import java.util.List;

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

        Asserts.test(list.indexof(44) == 3);
        Asserts.test(list.indexof(22) == List.ELEMENT_NOT_FOUND);
        Asserts.test(list.contains(33));
        Asserts.test(list.get(0) == 11);
        Asserts.test(list.get(1) == 66);
        Asserts.test(list.get(list.size() - 1) == 44);

        System.out.println(list);

    }

    public static void main(String[] args) {

        testList(new LinkedList<>());

//        List<Integer> list = new LinkedList<>();
//        for (int i = 0; i < 10; i++) {
//            list.add(i);
//        }
//        System.out.println(list.toString());
//        list.set(5, 10);
//        Asserts.test(list.get(5) == 10);
//        list.add(0, 100);
//        Asserts.test(list.get(0) == 100);
//        Asserts.test(list.size() == 11);
//        list.remove(8);
//        Asserts.test(list.size() == 10);


    }
}
