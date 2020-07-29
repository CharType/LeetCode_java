package com.头条高频算法题;

import com.tools.Integers;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/merge-intervals/
 */
public class _56_合并区间 {

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[0][];
        if (intervals.length == 1) return intervals;
        PriorityQueue queue = new PriorityQueue(intervals.length, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int [] nums1 = (int[])o1;
                int [] nums2 = (int[])o2;
                return nums1[0] - nums2[0];
            }
        });

        for (int i = 0;i < intervals.length;i++) {
            int [] nums = intervals[i];
            if (nums.length == 2) {
                queue.add(nums);
            }
        }

        List<int []> list = new ArrayList<>();

        int [] nums = null;
        while (!queue.isEmpty()) {
                int [] array = (int [])queue.remove();
                if (nums == null) {
                    nums = array;
                } else {
                    if (nums[1] >= array[1]) continue;
                    if(nums[1] >= array[0]) {
                        nums = new int[]{nums[0], array[1]};
                    } else {
                        list.add(nums);
                        nums = array;
                    }
                }
        }
        if (nums != null) {
            list.add(nums);
        }


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
