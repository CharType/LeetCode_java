package com.cq.source;

//import java.util.LinkedList;
//import java.util.List;

import com.tools.Asserts;

public class Main {
    public static void main(String[] args) {

        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println(list.toString());
        list.set(5, 10);
        Asserts.test(list.get(5) == 10);
        list.add(0, 100);
        Asserts.test(list.get(0) == 100);
        Asserts.test(list.size() == 11);
        list.remove(8);
        Asserts.test(list.size() == 10);


    }
}
