package com.探索.腾讯.数组和字符串;

/**
 *https://leetcode-cn.com/explore/interview/card/tencent/221/array-and-strings/895/
 */
public class 寻找两个正序数组的中位数 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int [] nums = new int[nums1.length + nums2.length];
        int n1Index = 0,n2Index = 0,index = 0;
        while (n1Index < nums1.length && n2Index < nums2.length) {
            if (nums1[n1Index] > nums2[n2Index]) {
                nums[index] = nums2[n2Index++];
            } else {
                nums[index] = nums1[n1Index++];
            }
            index++;
        }
        while (n1Index < nums1.length) {
            nums[index++] = nums1[n1Index++];
        }
        while (n2Index < nums2.length) {
            nums[index++] = nums2[n2Index++];
        }
        if (nums.length % 2 == 0) {

            return (nums[nums.length / 2 - 1] + nums[nums.length / 2]) / 2.f;
        } else  {
            return nums[nums.length / 2];
        }
    }

    public static void main(String[] args) {
        寻找两个正序数组的中位数 o = new 寻找两个正序数组的中位数();
        int [] nums1 = {1,2};
        int [] nums2 = {3,4};
        System.out.println(o.findMedianSortedArrays(nums1,nums2));
    }
}
