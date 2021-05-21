package com.探索.头条.数组;

import com.tools.Integers;

/**
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class _34_在排序数组中查找元素的第一个和最后一个位置 {

    public int[] searchRange(int[] nums, int target) {
        int [] result = {-1, -1};
        if (nums == null || nums.length == 0) return  result;
        if (nums.length == 1 && nums[0] == target) {
            result[0] = 0;
            result[1] = 0;
            return result;
        }
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = ((right - left) / 2) + left;
            if (nums[mid] > target) {
                right = mid-1;
            } else if(nums[mid] < target)  {
                left = mid+1;
            } else {
                break;
            }
        }
        if (nums[mid] == target) {
            left = mid;
            right = mid;
            while ((left - 1) >= 0 && nums[left - 1] == target) {
                left--;
            }
            while ((right+1) < nums.length &&nums[right + 1] == target) {
                right++;
            }
            result[0] = left;
            result[1] = right;
        }

        return result;

    }

    public static void main(String[] args) {
        _34_在排序数组中查找元素的第一个和最后一个位置 o = new _34_在排序数组中查找元素的第一个和最后一个位置();
//        int [] nums = {5,7,7,8,8,10};
//        Integers.println(o.searchRange(nums,8));
//        int [] nums1 = {1};
//        Integers.println(o.searchRange(nums1,1));
//        int [] nums2 = {2,2};
//        Integers.println(o.searchRange(nums2,2));
//        int [] nums3 = {1,4};
//        Integers.println(o.searchRange(nums3,4));
        int [] nums4 = {1,1,2};
        Integers.println(o.searchRange(nums4,1));

    }
}
