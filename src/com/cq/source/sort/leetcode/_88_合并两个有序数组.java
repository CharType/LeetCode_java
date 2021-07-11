package com.cq.source.sort.leetcode;

import com.tools.Integers;

/**
 * https://leetcode-cn.com/problems/merge-sorted-array/
 */
public class _88_合并两个有序数组 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int mIndex = m - 1;
        int nIndex = n - 1;
        int currentIndex = nums1.length - 1;
        while (nIndex >= 0) {
            if (mIndex >= 0 && nums1[mIndex] > nums2[nIndex]) {
                nums1[currentIndex] = nums1[mIndex];
                mIndex--;
            } else {
                nums1[currentIndex] = nums2[nIndex];
                nIndex--;
            }
            currentIndex--;
        }
    }

    public static void main(String[] args) {
        _88_合并两个有序数组 o = new _88_合并两个有序数组();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        o.merge(nums1, 3, nums2, 3);
        Integers.println(nums1);
    }
}
