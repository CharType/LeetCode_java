package com.arithmetic.精选Top面试题.简单;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/count-and-say/
 * 1.     1      一个1
 * 2.     11     数字11 表示 1个1
 * 3.     21     数字21 表示 2个1
 * 4.     1211   数字1221 表示1个2，1个1
 * 5.     111221 数字111221 表示 1个1 1个2 2个1
 * 6.     312211
 * 7.     13112221
 * 8.     1113213211
 * 9      31131211131221
 *
 */
public class _38_外观数列 {
    public String countAndSay(int n) {
        List<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>(n);
        ArrayList oneList = new ArrayList<Integer>(1);
        oneList.add(1);
        list.add(oneList);
        for (int i= 1; i<n;i++) {
            ArrayList newList = new ArrayList<Integer>(i);
            ArrayList<Integer> temp = list.get(i-1);
            if (temp.size() == 1) {
                newList.add(1);
                newList.add(temp.get(0));
            } else {
                // 1.遍历 统计相等的数字 将描述添加到到数组中
                int lastNum = temp.get(0);
                int lasNumNum = 1;
                for (int j = 1;j < temp.size();j++) {
                    if (temp.get(j) == lastNum) {
                        lasNumNum++;
                        continue;
                    } else {
                        newList.add(lasNumNum);
                        newList.add(lastNum);
                        lasNumNum = 1;
                        lastNum = temp.get(j);
                    }
                }
                newList.add(lasNumNum);
                newList.add(lastNum);
            }
            list.add(newList);
        }
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> array = list.get(list.size()-1);
        for (int i = 0;i <array.size();i++) {
            sb.append(array.get(i));
        }
        return sb.toString();
//        return list.get(list.size()-1).toString();
    }

    public static void main(String[] args) {
        _38_外观数列 o = new _38_外观数列();
        System.out.println(o.countAndSay(30));
    }
}
