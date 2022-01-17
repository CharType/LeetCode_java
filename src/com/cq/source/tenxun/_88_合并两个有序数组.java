package com.cq.source.tenxun;

import com.tools.Integers;

public class _88_合并两个有序数组 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 到着遍历，避免第一个数组中的数据移动问题
        int m1Index = m - 1;
        int n2Index = n - 1;
        int iIndex = nums1.length - 1;
        while (m1Index >= 0 && n2Index >= 0) {
            if (nums1[m1Index] < nums2[n2Index]) {
                nums1[iIndex] = nums2[n2Index];
                n2Index--;
            } else {
                nums1[iIndex] = nums1[m1Index];
                m1Index--;
            }
            iIndex--;
        }

        while (n2Index >= 0) {
            nums1[iIndex] = nums2[n2Index];
            n2Index--;
            iIndex--;
        }
    }

    public static void main(String[] args) {
        _88_合并两个有序数组 o = new _88_合并两个有序数组();
        int[] num1 = {1, 2, 3, 0, 0, 0};
        int[] num2 = {2, 5, 6};
        o.merge(num1, 3, num2, 3);
        Integers.println(num1);
    }
}
