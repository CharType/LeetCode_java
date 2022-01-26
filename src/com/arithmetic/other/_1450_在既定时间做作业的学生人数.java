package com.arithmetic.other;

/**
 * https://leetcode-cn.com/problems/number-of-students-doing-homework-at-a-given-time/
 */
public class _1450_在既定时间做作业的学生人数 {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int count = 0;
        int startIndex = 0;
        int endIndex = 0;
        while (startIndex < startTime.length) {
            if (startTime[startIndex] <= queryTime && endTime[endIndex] >= queryTime) {
                count++;
            }
            startIndex++;
            endIndex++;
        }
        return count;
    }

    public static void main(String[] args) {
        _1450_在既定时间做作业的学生人数 o = new _1450_在既定时间做作业的学生人数();
        int [] startTime = {1,2,3};
        int [] endTime = {3,2,7};
        System.out.println(o.busyStudent(startTime,endTime,4));
    }
}
