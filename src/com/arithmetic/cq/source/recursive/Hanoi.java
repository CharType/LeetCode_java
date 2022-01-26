package com.arithmetic.cq.source.recursive;

// 解决汉诺塔类型题目
public class Hanoi {
    public static void main(String[] args) {
        new Hanoi().hanoi(3, "A", "B", "C");
    }

    /**
     * 将n个盘子从 p1
     *
     * @param n
     * @param p1
     * @param p2
     * @param p3
     */
    public void hanoi(int n, String p1, String p2, String p3) {
        if (n < 2) {
            move(n, p1, p3);
            return;
        }
        hanoi(n - 1, p1, p3, p2);
        move(n, p1, p3);
        hanoi(n - 1, p2, p1, p3);
    }

    public void move(int i, String from, String to) {
        System.out.println("将第" + i + "个碟子，从第" + from + "个柱子移动到第" + to + "个柱子");
    }
}
