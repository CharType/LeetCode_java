package com.arithmetic.cq.source.tenxun;


public class _4_寻找两个正序数组的中位数 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null && nums2 == null) return 0;
        int m = nums1.length;
        int n = nums2.length;
        int[] nums = new int[m + n];
        int mindex = 0, nindex = 0, index = 0;

        while (mindex < m && nindex < n) {
            if (nums1[mindex] < nums2[nindex]) {
                nums[index] = nums1[mindex];
                mindex++;
            } else {
                nums[index] = nums2[nindex];
                nindex++;
            }
            index++;
        }
        while (mindex < m) {
            nums[index] = nums1[mindex];
            mindex++;
            index++;
        }
        while (nindex < n) {
            nums[index] = nums2[nindex];
            nindex++;
            index++;
        }
        if (((m + n) & 1) == 1) {
            return nums[(m + n) >> 1];
        }
        return (nums[(nums.length >> 1) - 1] + nums[nums.length >> 1]) / 2.0;
    }

    public static void main(String[] args) {
        _4_寻找两个正序数组的中位数 o = new _4_寻找两个正序数组的中位数();
        int[] nums1 = {1, 3};
        int[] nums2 = {2, 5};

        System.out.println(o.findMedianSortedArrays(nums1, nums2));
    }
}
