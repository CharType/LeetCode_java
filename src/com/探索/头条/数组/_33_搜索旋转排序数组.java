package com.探索.头条.数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _33_搜索旋转排序数组 {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return -1;
        if (n == 1) return nums[0] == target ? 0 : -1;
        int l = 0,r = n - 1;
        while (l <= r) {
            int mid = (l + r)/2;
            if (nums[mid] == target) return  mid;
            if (nums[0] <= nums[mid]) {
                // 判断数据是否在前半部分
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    // 数据在后半部分
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                   // 数据在后半部分
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }



    public static void main(String[] args) {
        _33_搜索旋转排序数组 o = new _33_搜索旋转排序数组();
        int [] nums = {4,5,6,7,0,1,2};
        System.out.print(o.search(nums,0));
    }

    /**
     *https://leetcode-cn.com/problems/3sum/
     */
    public static class _5_三数之和 {
        public List<List<Integer>> threeSum(int[] nums) {
            int n = nums.length;
            // 先进行排序
            Arrays.sort(nums);
            List<List<Integer>> ans = new ArrayList<>();
            // 枚举 a
            for (int first = 0; first < n; ++first) {
                // 需要和上一次枚举的数不相同
                if (first > 0 && nums[first] == nums[first - 1]) {
                    continue;
                }
                // c 对应的指针初始指向数组的最右端
                int third = n - 1;
                int target = -nums[first];
                // 枚举 b
                for (int second = first + 1; second < n; ++second) {
                    // 需要和上一次枚举的数不相同
                    if (second > first + 1 && nums[second] == nums[second - 1]) {
                        continue;
                    }
                    // 需要保证 b 的指针在 c 的指针的左侧
                    while (second < third && nums[second] + nums[third] > target) {
                        --third;
                    }
                    // 如果指针重合，随着 b 后续的增加
                    // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                    if (second == third) {
                        break;
                    }
                    if (nums[second] + nums[third] == target) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(nums[first]);
                        list.add(nums[second]);
                        list.add(nums[third]);
                        ans.add(list);
                    }
                }
            }
            return ans;
        }

        public static void main(String[] args) {
            _5_三数之和 o = new _5_三数之和();
            int [] nums = {-1, 0, 1, 2, -1, -4};
            System.out.println(o.threeSum(nums));
            System.out.println(o.threeSum(nums));
        }
    }
}
