package com.每日一题;

import com.tools.Integers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
 */
public class _350_两个数组的交集II {

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return  new  int[0];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < nums1.length & j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if(nums1[i] > nums2[j]) {
                j++;
            } else {
                nums1[k++] = nums1[i++];
                j++;
            }
        }
        return Arrays.copyOfRange(nums1,0,k);
    }

    public static void main(String[] args) {
        _350_两个数组的交集II o = new _350_两个数组的交集II();
        int [] nums1 = {2,2};
        int [] nums2 = {1,2,2,1};
        System.out.println("重复的元素有：");
        Integers.println(o.intersect(nums2,nums1));

    }
}
