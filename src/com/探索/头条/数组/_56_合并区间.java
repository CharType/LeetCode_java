package com.探索.头条.数组;

import com.tools.Integers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/merge-intervals/
 */
public class _56_合并区间 {

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[0][];
        if (intervals.length == 1) return intervals;
        // 定义一个优先级队列，已数组的第一个元素排序
        PriorityQueue queue = new PriorityQueue(intervals.length, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int [] nums1 = (int[])o1;
                int [] nums2 = (int[])o2;
                return nums1[0] - nums2[0];
            }
        });
        // 原地建堆
        for (int i = 0;i < intervals.length;i++) {
            int [] nums = intervals[i];
            if (nums.length == 2) {
                queue.add(nums);
            }
        }

        List<int []> list = new ArrayList<>();
        //记录上次遍历的区间
        int [] nums = null;
        while (!queue.isEmpty()) {
                // 获取到当前的区间
                int [] array = (int [])queue.remove();
                if (nums == null) {
                    // 如果上次的区间是空的，保存一下
                    nums = array;
                } else {
                    // 如果上次区间的结尾大于本次区间的结尾，说明上次区间包含本次区间，直接跳过
                    if (nums[1] >= array[1]) continue;
                    if(nums[1] >= array[0]) {
                        //如果上次区间的结尾大于本次区间的开头
                        // 那么上次区间和本次区间合并
                        nums = new int[]{nums[0], array[1]};
                    } else {
                        // 否则将上次区间添加到数组中
                        list.add(nums);
                        // 记录一下本次的区间
                        nums = array;
                    }
                }
        }
        // 数组中最后的区间添加一下
        if (nums != null) {
            list.add(nums);
        }

        //转换为数组返回
        return list.toArray(new int[list.size()][2]);
    }

    public static void main(String[] args) {
        _56_合并区间 o = new _56_合并区间();
        int [][] intervals = {{1,3},{2,6},{8,10},{15,18}};
//        int [][] intervals = {{1,4},{2,3}};
//        int [][] intervals = {{1,4},{4,5}};
//        int [][] intervals = {{1,4},{1,4}};
//        int [][] intervals = {{2,3},{4,5},{6,7},{8,9},{1,10}};
        int [][] results = o.merge(intervals);
        for (int i = 0;i < results.length;i++) {
            int [] nums = results[i];
            Integers.println(nums);
        }
    }
}
