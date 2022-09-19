package com.xkcoding.leetcode._prepare.queue;

/**
 * <p>
 * 给定一个整数数据流和一个窗口大小，根据该滑动窗口的大小，计算其所有整数的移动平均值。
 * <p>
 * 示例:
 * <p>
 * MovingAverage m = new MovingAverage(3);
 * m.next(1) = 1
 * m.next(10) = (1 + 10) / 2
 * m.next(3) = (1 + 10 + 3) / 3
 * m.next(5) = (10 + 3 + 5) / 3
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2020-07-14 14:30
 */
class MovingAverage {

    private int[] queue;
    private int size;
    private int head = 0;
    private int count = 0;
    private int windowSum = 0;

    /**
     * Initialize your data structure here.
     */
    public MovingAverage(int size) {
        queue = new int[size];
        this.size = size;
    }

    public double next(int val) {
        count++;
        // 计算尾部指针
        int tail = (head + 1) % size;
        // 新添加的元素覆盖旧的元素，即窗口向右滑动
        windowSum = windowSum - queue[tail] + val;
        head = (head + 1) % size;
        queue[head] = val;

        return windowSum * 1.0 / (Math.min(size, count));

    }

    public static void main(String[] args) {
        MovingAverage m = new MovingAverage(3);
        System.out.println(m.next(1));
        System.out.println(m.next(10));
        System.out.println(m.next(3));
        System.out.println(m.next(5));
    }
}
