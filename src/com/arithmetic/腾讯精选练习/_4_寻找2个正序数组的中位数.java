package com.arithmetic.腾讯精选练习;

/**
 * 给定两个大小为 m 和 n 的正序（从小到大）数组nums1 和nums2。请你找出并返回这两个正序数组的中位数。
 *
 * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？ 二分查找
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 */
public class _4_寻找2个正序数组的中位数 {

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        int index1 = 0, index2 = 0;
        int isq = length & 1;
        while (index1 < nums1.length && index2 <  nums2.length) {
            if (nums1[index1] < nums2[index2]) {
                index1++;
            } else {
                index2++;
            }
            if (isq != 0) {
                int index = length >> 1;
                if (index == (index1 + index2)) {
                    if (nums1[index1] < nums2[index2]) {
                        return nums2[index2];
                    } else {
                        return nums1[index1];
                    }
                }
            } else {
                int index = length >> 1;
                if (index == (index1 + index2)) {
                    Integer maxValue = Integer.max(nums1[index1],nums2[index2]);
                    Integer minValue = Integer.max(Integer.min(nums1[index1],nums2[index2]), Integer.max(nums1[index1 -1], nums2[index2 - 1]));
                    return  (maxValue + minValue) / 2.0;
                }
            }
        }




        return 0;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null && nums1.length == 0 && nums2 == null && nums2.length == 0) return -1;
        int length = nums1.length + nums2.length;
        int [] meargeNums = new int [length];
        int isq = length & 1;


        int nums1Index = 0, nums2Index = 0, meargeIndex = 0;

        while (nums1Index < nums1.length && nums2Index < nums2.length) {
            if (nums1[nums1Index] < nums2[nums2Index]) {
                meargeNums[meargeIndex] = nums1[nums1Index];
                nums1Index++;
            } else {
                meargeNums[meargeIndex] = nums2[nums2Index];
                nums2Index++;
            }
            meargeIndex++;
        }

        while (nums1Index < nums1.length) {
            meargeNums[meargeIndex] = nums1[nums1Index];
            nums1Index++;
            meargeIndex++;
        }

        while (nums2Index < nums2.length) {
            meargeNums[meargeIndex] = nums2[nums2Index];
            nums2Index++;
            meargeIndex++;
        }

        if (isq == 0) {
            return (meargeNums[(length >> 1) - 1] + meargeNums[length >> 1]) / 2.0;
        } else {
            return meargeNums[length >> 1];
        }
    }

    public static void main(String[] args) {
        _4_寻找2个正序数组的中位数 o = new _4_寻找2个正序数组的中位数();
        int [] nums1 = {1, 3};
        int [] nums2 = {2};
        System.out.println(o.findMedianSortedArrays(nums1,nums2));
    }
}
