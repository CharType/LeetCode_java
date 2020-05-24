package com.高频题;

import com.tools.Integers;

/**
 * https://leetcode-cn.com/problems/move-zeroes/
 */
public class _283_移动零 {
    // 记录一下交换的次数
    private int swopCount;
    public void moveZeroes(int[] nums) {
        // 当前交换数字的指针
        int currrent = 0;
        // 遍历指针
        int index = 0;
        while (index < nums.length) {
            if (nums[index] != 0) {
                //如果!= 0 就将currrent 和index 交换 crrrent++;
                swop(nums, currrent, index);
                currrent++;
            }
            // 无论如何 index++
            index++;
        }
    }

    private void  swop(int [] nums, int i1, int i2) {
        // 避免重复的交换
        if (nums[i1] == nums[i2]) return;
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
        // 测试数据
        swopCount++;
        System.out.println("第"+ swopCount +"次交换, i1 = " + i1 + "i2 = "+ i2);
    }

    public static void main(String[] args) {
        _283_移动零 o = new _283_移动零();
        int [] nums = new int[]{1,1,0,3,12};
        o.moveZeroes(nums);
        Integers.println(nums);

    }
}
