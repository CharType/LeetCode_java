package com.arithmetic.other;

import java.util.*;


/**
 * https://leetcode-cn.com/problems/destination-city/
 */
public class _1436_旅行终点站 {

    public String destCity(List<List<String>> paths) {
        if (paths == null || paths.size() == 0) return null;
        Map<String,String> map = new HashMap<>();
        List<String> begin = paths.get(0);
        for (int i = 0;i < paths.size();i++) {
            List<String> list = paths.get(i);
            if (list.size() >=2) {
                map.put(list.get(0),list.get(1));
            }
        }
        String end = begin.get(1);
        while (map.get(end) != null) {
            end = map.get(end);
        }
        return end;
    }

    public static void main(String[] args) {
        _1436_旅行终点站 o = new _1436_旅行终点站();
        List<List<String>> list = new ArrayList<>();
        List<String> array = new ArrayList<>();
        array.add("London");
        array.add("New York");
        List<String> array1 = new ArrayList<>();
        array1.add("New York");
        array1.add("Lima");
        List<String> array2 = new ArrayList<>();
        array2.add("Lima");
        array2.add("Sao Paulo");
        list.add(array);
        list.add(array1);
        list.add(array2);
        System.out.println(o.destCity(list));

    }


}
