package com.arithmetic.每日一题;

public class _4_寻找两个正序数组的中位数 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return 0;
        int length = nums1.length + nums2.length;
        int index1 = 0, index2 = 0, index = 0;

        if (length % 2 == 1) {
            while (index1 < nums1.length && index2 < nums2.length) {
                if (index == length / 2 + 1) {
                    if (nums1[index1] < nums2[index2]) {
                        return nums1[index1];
                    } else {
                        return nums2[index2];
                    }
                }
                if (nums1[index1] < nums2[index2]) {
                    index1++;
                } else {
                    index2++;
                }
                index++;
            }

            while (index1 < nums1.length) {
                if (index == length / 2 + 1) {
                    return nums1[index1];
                }
                index1++;
                index++;
            }

            while (index2 < nums2.length) {
                if (index == length / 2 + 1) {
                    return nums2[index2];
                }
                index2++;
                index++;
            }

        } else {
            int result = 0, result2 = 0;
            while (index1 < nums1.length && index2 < nums2.length) {
                if (index == length / 2) {
                    if (nums1[index1] < nums2[index2]) {
                        result = nums1[index1];
                    } else {
                        result = nums2[index2];
                    }

                }
                if (nums1[index1] < nums2[index2]) {
                    if (index == length / 2 + 1) {
                        result2 = nums1[index1];
                        break;
                    }
                    index1++;
                } else {
                    if (index == length / 2 + 1) {
                        result2 = nums2[index2];
                        break;
                    }
                    index2++;
                }
                index++;

            }
            return (result + result2) / 2.0;
        }
        return 0;
    }

    public static void main(String[] args) {
        _4_寻找两个正序数组的中位数 o = new _4_寻找两个正序数组的中位数();
        int[] num1 = {1, 3, 5, 7, 9};
        int[] num2 = {2, 4, 6, 8, 10};
        System.out.println(o.findMedianSortedArrays(num1, num2));
        System.out.println("哈哈");
    }
}
