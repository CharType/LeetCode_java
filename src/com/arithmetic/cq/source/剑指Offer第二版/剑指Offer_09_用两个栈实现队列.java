package com.arithmetic.cq.source.剑指Offer第二版;

import com.arithmetic.cq.source.stack.Stack;

public class 剑指Offer_09_用两个栈实现队列 {
    public static void main(String[] args) {
        CQueue queue = new CQueue();
        queue.appendTail(1);
        queue.appendTail(2);
        queue.appendTail(3);
        queue.appendTail(4);
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
    }
}

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * 示例 2：
 * <p>
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 */

class CQueue {
    Stack<Integer> inStack;
    Stack<Integer> outStack;

    public CQueue() {
        this.inStack = new Stack<>();
        this.outStack = new Stack<>();
    }

    public void appendTail(int value) {
        inStack.push(value);
    }

    public int deleteHead() {
        if (inStack.isEmpty() && outStack.isEmpty()) return -1;
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }
}