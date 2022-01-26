package com.arithmetic.高频题;

import java.util.Arrays;

/**
 *https://leetcode-cn.com/problems/meeting-rooms-ii/
 * 问至少需要多少间会议室才能满足这些安排
 */
public class _253_会议室二 {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals,(m1, m2) -> m1[0] - m2[0]);

        return 1;
    }

    public static void main(String[] args) {
        _253_会议室二 o = new _253_会议室二();
        int [][] nums = {{2, 4},{5,8},{9,12}};

    }
}
