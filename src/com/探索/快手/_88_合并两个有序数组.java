package com.探索.快手;

import com.tools.Integers;

/**
 * https://leetcode-cn.com/problems/merge-sorted-array/
 */
public class _88_合并两个有序数组 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int num1Index = m -1;
        int num2Index = n -1;
        int currentIndex = nums1.length - 1;
        while (num1Index >= 0 && num2Index >= 0 ) {
            if (nums1[num1Index] > nums2[num2Index]) {
                nums1[currentIndex] = nums1[num1Index];
                num1Index--;
            } else {
                nums1[currentIndex] = nums2[num2Index];
                num2Index--;
            }
            currentIndex--;
        }
        while (num2Index >= 0) {
            nums1[currentIndex--] = nums2[num2Index--];
        }

    }

    public static void main(String[] args) {
        _88_合并两个有序数组 o = new _88_合并两个有序数组();
        int [] num1 = {1,2,3,0,0,0};
        int [] num2 = {2,5,6};
        o.merge(num1,3,num2,3);
        Integers.println(num1);
    }
}
