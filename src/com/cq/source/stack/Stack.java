package com.cq.source.stack;

import com.cq.source.list.List;
import com.cq.source.list.array.ArrayList;

public class Stack<E> {
    private List<E> list = new ArrayList<>();

    // 栈中元素的数量
    public int size() {
        return this.list.size();
    }

    // 是否为空
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    // 入栈
    public void push(E element) {
        this.list.add(element);
    }

    // 出栈
    public E pop() {
        return this.list.remove(list.size() - 1);
    }

    // 查看栈顶元素
    public E peek() {
        return this.list.get(list.size() - 1);
    }

    // 清空栈
    public void clear() {
        this.list.clear();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        while (!this.isEmpty()) {
            sb.append(" " + this.pop());
        }
        sb.append(']');
        return sb.toString();
    }
}
