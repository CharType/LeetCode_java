package com.arithmetic.头条高频算法题;

/**
 * 4. 寻找两个正序数组的中位数
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 */
public class _4_寻找两个正序数组的中位数 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] meargeList = new int[nums1.length + nums2.length];
        int index1 = 0;
        int index2 = 0;
        int i = 0;
        int isq = (nums1.length + nums2.length) & 1;

        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] < nums2[index2]) {
                meargeList[i] = nums1[index1];
                index1++;
            } else {
                meargeList[i] = nums2[index2];
                index2++;
            }
            i++;
        }
        while (index1 < nums1.length) {
            meargeList[i] = nums1[index1];
            index1++;
            i++;
        }

        while (index2 < nums2.length) {
            meargeList[i] = nums2[index2];
            index2++;
            i++;
        }

        if (isq == 1) {
            return meargeList[meargeList.length >> 1];
        } else {
            return (meargeList[(meargeList.length >> 1) - 1] + meargeList[meargeList.length >> 1]) / 2.0;
        }

    }


    public static void main(String[] args) {
        _4_寻找两个正序数组的中位数 o = new _4_寻找两个正序数组的中位数();
        int[] nums1 = {1, 3};
        int[] nums2 = {2, 5};
        System.out.println(o.findMedianSortedArrays(nums1, nums2));
//        System.out.println(Integer.toString(-121));
    }
}
