package com.探索.腾讯.数组和字符串;

import com.tools.Integers;

/**
 * https://leetcode-cn.com/explore/interview/card/tencent/221/array-and-strings/914/
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * 说明:
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 */
public class 合并两个有序数组 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null) return;
        int mindex = m - 1;
        int nIndex = n - 1;
        int currentIndex = nums1.length - 1;
        while (nIndex >= 0) {
            if (mindex >= 0 && nums1[mindex] > nums2[nIndex]) {
                nums1[currentIndex] = nums1[mindex];
                mindex--;
            } else {
                nums1[currentIndex] = nums2[nIndex];
                nIndex--;
            }
            currentIndex--;
        }
    }

    public static void main(String[] args) {
        合并两个有序数组 o = new 合并两个有序数组();
        int [] num1 = {1,2,3,0,0,0};
        int [] num2 = {2,5,6};
        o.merge(num1,3,num2,3);
        Integers.println(num1);
    }
}
