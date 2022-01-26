package com.arithmetic.高频题;

/**
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 */
public class _4_寻找两个正序数组的中位数 {
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        // 1. 先将2个有序的数组合并成一个有序的数组
        int m = nums1.length;
        int n = nums2.length;
        int [] meargeNums = new int [m+n];
        int mIndex = 0;
        int nIndex = 0;
        int current = 0;
        while (current < meargeNums.length) {
            if (mIndex < nums1.length && nIndex < nums2.length) {
                if ( nums1[mIndex] < nums2[nIndex]) {
                    meargeNums[current] = nums1[mIndex];
                    mIndex++;
                } else if( nums1[mIndex] >= nums2[nIndex]) {
                    meargeNums[current] = nums2[nIndex];
                    nIndex++;
                }
            } else {
                break;
            }
            current++;
        }
        if (mIndex < nums1.length) {
            while (current < meargeNums.length) {
                meargeNums[current] = nums1[mIndex];
                mIndex++;
                current++;
            }
        } else if (nIndex < nums2.length) {
            while (current < meargeNums.length) {
                meargeNums[current] = nums2[nIndex];
                nIndex++;
                current++;
            }
        }
        if (((m + n) & 1) == 0) {
            // 2  如果 m + n 是偶数 中位数索引 是 (m + n)/2 和 (m + n)/2 +1   2个值在除于2
            return (meargeNums[((m + n) >> 1) - 1] + meargeNums[((m + n) >> 1)]) / 2.0;
        } else {
            // 3，如果m + n 是奇数 中位数索引 是 (m + n)/2+1
            return meargeNums[(m + n) >> 1];
        }
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 1. 先将2个有序的数组合并成一个有序的数组
        int m = nums1.length;
        int n = nums2.length;
        int [] meargeNums = new int [m+n];
        int mIndex = 0;
        int nIndex = 0;
        int current = 0;
        while (current < meargeNums.length) {
            if (mIndex < nums1.length && nIndex < nums2.length) {
                if ( nums1[mIndex] < nums2[nIndex]) {
                    meargeNums[current] = nums1[mIndex];
                    mIndex++;
                } else if( nums1[mIndex] >= nums2[nIndex]) {
                    meargeNums[current] = nums2[nIndex];
                    nIndex++;
                }
            } else {
                break;
            }
            current++;
        }
        if (mIndex < nums1.length) {
            while (current < meargeNums.length) {
                meargeNums[current] = nums1[mIndex];
                mIndex++;
                current++;
            }
        } else if (nIndex < nums2.length) {
            while (current < meargeNums.length) {
                meargeNums[current] = nums2[nIndex];
                nIndex++;
                current++;
            }
        }
        if (((m + n) & 1) == 0) {
            // 2  如果 m + n 是偶数 中位数索引 是 (m + n)/2 和 (m + n)/2 +1   2个值在除于2
            return (meargeNums[((m + n) >> 1) - 1] + meargeNums[((m + n) >> 1)]) / 2.0;
        } else {
            // 3，如果m + n 是奇数 中位数索引 是 (m + n)/2+1
            return meargeNums[(m + n) >> 1];
        }
    }

    public static void main(String[] args) {
        _4_寻找两个正序数组的中位数 o = new _4_寻找两个正序数组的中位数();
        int [] num1 = {1,3,5,7,9};
        int [] num2 = {2,4,6,8,10};
        System.out.println(o.findMedianSortedArrays(num1,num2));
        System.out.println("哈哈");
    }
}
