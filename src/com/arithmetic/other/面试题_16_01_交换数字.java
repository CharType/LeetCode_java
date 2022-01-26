package com.arithmetic.other;

import com.arithmetic.tools.Integers;

public class 面试题_16_01_交换数字 {
    public int[] swapNumbers(int[] numbers) {
        if (numbers == null || numbers.length <= 1) return numbers;
        numbers[0] = numbers[0] + numbers[1];
        numbers[1] = numbers[0] - numbers[1];
        numbers[0] = numbers[0] - numbers[1];
        return numbers;
    }

    public static void main(String[] args) {
        int [] nums = {1,2};
        面试题_16_01_交换数字 o  = new 面试题_16_01_交换数字();
        Integers.println(o.swapNumbers(nums));
    }
}
