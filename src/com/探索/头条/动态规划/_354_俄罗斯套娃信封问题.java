package com.探索.头条.动态规划;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/russian-doll-envelopes/
 * 暂时不会做了
 * 先开始值排序  然后是一个最长递增子序列的问题
 */
public class _354_俄罗斯套娃信封问题 {

    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) return 0;
        PriorityQueue<int []> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });
        for (int i = 0;i < envelopes.length;i++) {
            if (envelopes[i] != null && envelopes[i].length > 1) {
                queue.add(envelopes[i]);
            }
        }

        List<int[]> list = new ArrayList<>();
        int [] tempNums = null;
        while (!queue.isEmpty()){
           int [] nums = queue.poll();
           if (tempNums == null){
               tempNums = nums;
           } else {
               if (nums[0] > tempNums[0] && nums[1] > tempNums[1]) {
                   list.add(tempNums);
                   tempNums = nums;
                   if (queue.isEmpty()) {
                       list.add(nums);
                       tempNums = null;
                   }
               }
           }
        }
        if (tempNums != null) {
            list.add(tempNums);
        }

        return list.size();

    }

    public static void main(String[] args) {
        _354_俄罗斯套娃信封问题 o = new _354_俄罗斯套娃信封问题();
//        int [][] envelopes = {
//                {5,4},
//                {6,4},
//                {6,7},
//                {2,3}
//        };

//        int [][] envelopes = {
//                {1,1},
//                {1,1},
//                {1,1}
//        };

        //[[2,100],[3,200],[4,300],[5,500],[5,400],[5,250],[6,370],[6,360],[7,380]]

        int [][] envelopes = {
                {2,100},
                {3,200},
                {4,300},
                {5,500},
                {5,400},
                {5,250},
                {6,370},
                {6,360},
                {7,380},
        };
        System.out.println(o.maxEnvelopes(envelopes));

    }
}
