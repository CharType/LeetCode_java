package com.精选Top面试题.简单;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/pascals-triangle/
 */
public class _118_杨辉三角 {
    // 从第一行开始递推到下一行的值
    public List<List<Integer>> generate(int numRows) {
        if (numRows <= 0) return new ArrayList<>();
        List<List<Integer>> rootList = new ArrayList<List<Integer>>(numRows);
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<Integer>(i+1);
            if (i == 0) {
                list.add(1);
                rootList.add(list);
                continue;
            } else {
                List<Integer> lastList = rootList.get(i - 1);

                int nums = i+1;
                while (nums > 0) {
                    if ((nums == (i+1)) || nums == 1) {
                        list.add(1);
                    } else {
                        int lastLeftIndex = nums - 2;
                        int lastRightIndex = lastLeftIndex + 1;
                        list.add(lastList.get(lastLeftIndex) + lastList.get(lastRightIndex));
                    }

                    nums--;
                }
                rootList.add(list);
            }
        }
        return rootList;
    }

    public static void main(String[] args) {
        _118_杨辉三角 o = new _118_杨辉三角();
        List<List<Integer>> list = o.generate(5);
        System.out.println(list);

    }
}
