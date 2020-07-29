package com.探索.头条.数组;

import java.util.Arrays;

// https://leetcode-cn.com/problems/max-points-on-a-line/
public class _149_直线上最多的点数 {
    // 这个题的题解不太正确
    public int maxPoints(int[][] points) {
        if (points == null || points.length == 0) return 0;
        if (points.length == 1) return 1;
        Arrays.sort(points,(int [] o1,int [] o2) -> o1[0] - o2[0]);
        int maxX = 1;
        int count = 1;
        for (int i = 1;i < points.length;i++) {
            int [] prevPoint = points[i-1];
            int [] curPoint = points[i];
            if ((curPoint[0] == prevPoint[0] && curPoint[1] == prevPoint[1]) ||
                    (curPoint[0] - prevPoint[0] == 1 &&
                            (curPoint[1] - prevPoint[1] == 1 ||
                                    prevPoint[1]- curPoint[1] == 1))) {
                count++;
                maxX = Math.max(maxX,count);
            } else  {
                count = 1;
            }
        }

        Arrays.sort(points,(int [] o1,int [] o2) -> o1[1] - o2[1]);
        int maxY = 1;
        count = 1;
        for (int i = 1;i < points.length;i++) {
            int [] prevPoint = points[i-1];
            int [] curPoint = points[i];
            if (curPoint[0] == prevPoint[0] && curPoint[1] == prevPoint[1] ||
                    (curPoint[1] - prevPoint[1] == 1 && (curPoint[0] - prevPoint[0] == 1 ||  prevPoint[0]- curPoint[0] == 1))) {
                count++;
                maxY = Math.max(maxY,count);
            }
        }
        return maxX > maxY ? maxX : maxY;
    }

    public static void main(String[] args) {
        _149_直线上最多的点数 o = new _149_直线上最多的点数();
        int [][] nums = {
                {1,1},
                {3,2},
                {5,3}
        };
        //[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]
//        int [][] nums = {
//                {1,1},
//                {3,2},
//                {5,3},
//                {4,1},
//                {2,3},
//                {1,4}
//        };

//        int [][] nums = {
//                {0,0},
//                {0,0}
//        };
        System.out.println(o.maxPoints(nums));
    }
}
