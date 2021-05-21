package com.探索.快手;

import com.tools.Asserts;

import java.util.Stack;

public class _155_最小栈 {
    static class MinStack {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();
        /** initialize your data structure here. */
        MinStack() {

        }
        public void push(int val) {
            stack.push(val);
            if (minStack.isEmpty()) {
                minStack.push(val);
            } else if (minStack.peek() < val) {
                minStack.push(minStack.peek());
            } else {
                minStack.push(val);
            }
        }
        public void pop() {
            stack.pop();
            minStack.pop();
        }
        public int top() {
            return stack.peek();
        }
        public int getMin() {
            return minStack.peek();
        }
    }
    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        Asserts.test(stack.getMin() == 1);
        stack.push(-1);
        Asserts.test(stack.getMin() == -1);
        stack.pop();
        Asserts.test(stack.getMin() == 1);
    }
}
