package com.arithmetic.高频题;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/meeting-rooms/
 */
public class _252_会议室 {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return true;
        Arrays.sort(intervals,(m1,m2) -> m1[0] - m2[0]);

        for (int i = 1;i < intervals.length;i++) {
            if (intervals[i][0] < intervals[i - 1][1]) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        _252_会议室 o = new _252_会议室();
        int [][] nums = {{2, 4},{5,8},{9,12}};
        System.out.println(o.canAttendMeetings(nums));

    }

}
