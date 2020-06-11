package com.精选Top面试题.简单;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/fizz-buzz/
 */
public class _412_Fizz_Buzz {

    public List<String> fizzBuzz(int n) {
        if (n <= 0) return new ArrayList<>(0);
        List<String> list = new ArrayList<String>(n);
        for (int i= 1;i <=n;i++) {
            boolean three = i % 3 == 0;
            boolean five =  i % 5 == 0;
            if (three && five) {
                list.add("FizzBuzz");
            } else if (three) {
                list.add("Fizz");
            } else if (five) {
                list.add("Buzz");
            } else {
                list.add(Integer.toString(i));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        _412_Fizz_Buzz o = new _412_Fizz_Buzz();
        System.out.println(o.fizzBuzz(15));

    }

}
