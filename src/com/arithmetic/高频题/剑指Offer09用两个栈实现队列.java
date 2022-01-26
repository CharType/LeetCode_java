package com.arithmetic.高频题;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 */
public class 剑指Offer09用两个栈实现队列 {
    public static void main(String[] args) {

    }

    class CQueue {
        Stack<Integer> inStack;
        Stack<Integer> outStack;
        public CQueue() {
            this.inStack = new Stack<>();
            this.outStack = new Stack<>();
        }

        public void appendTail(int value) {
            this.inStack.add(value);
        }

        public int deleteHead() {
            if (outStack.isEmpty()) {
                if (!inStack.isEmpty()) {
                    while (!inStack.isEmpty()){
                        outStack.add(inStack.pop());
                    }
                    return outStack.pop();
                } else {
                    return -1;
                }
            } else {
                return outStack.pop();
            }
        }
    }
}
