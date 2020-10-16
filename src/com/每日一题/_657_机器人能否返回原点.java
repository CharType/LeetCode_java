package com.每日一题;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/robot-return-to-origin/
 */
public class _657_机器人能否返回原点 {
    public boolean judgeCircle2(String moves) {
        if (moves == null || moves.length() == 0) return true;
        char [] chars = moves.toCharArray();
        int [] arr = new int[100];
        for (char ch : chars) {
            arr[ch]++;
        }
        return  arr['U'] == arr['D'] && arr['L'] == arr['R'];

    }
    public boolean judgeCircle(String moves) {
        if (moves == null || moves.length() == 0) return true;
        char [] chars = moves.toCharArray();
        List<String> list = new LinkedList<>();
        for (int i=0;i < chars.length;i++) {
            if (list.size() == 0) {
                list.add(String.valueOf(chars[i]));
            } else {
                if (chars[i] == 'U') {
                    if (list.contains("D")) {
                        list.remove("D");
                    } else {
                        list.add("U");
                    }
                }

                if (chars[i] == 'D') {
                    if (list.contains("U")) {
                        list.remove("U");
                    } else {
                        list.add("D");
                    }
                }

                if (chars[i] == 'L') {
                    if (list.contains("R")) {
                        list.remove("R");
                    } else {
                        list.add("L");
                    }
                }

                if (chars[i] == 'R') {
                    if (list.contains("L")) {
                        list.remove("L");
                    } else {
                        list.add("R");
                    }
                }
            }
        }
        return list.size() == 0;
    }

    public static void main(String[] args) {
        _657_机器人能否返回原点 o = new _657_机器人能否返回原点();
        System.out.println(o.judgeCircle2("UD"));
    }
}
