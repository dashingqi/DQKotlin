package com.dashingqi.arithmetic.queue;

/**
 * @author : zhangqi
 * @desc : 环形队列
 * @time : 2023/2/27 23:23
 */
public class CircleQueue {

    private String[] items;

    private int n = 0;

    private int head = 0;

    private int tail = 0;

    public CircleQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    // 入队
    public boolean enqueue(String item) {
        // 队列满了；
        if ((tail + 1) % n == head) return false;
        items[tail] = item;
        tail = (tail + 1) % n;
        return true;
    }


    // 出队
    public String dequeue() {
        // 表示队列为空
        if (head == tail) return null;
        String tempItem = items[head];
        head = (head + 1) % n;
        return tempItem;
    }

    // 取模运算 = 除数 * (整商+1) - 被除数

    // 被除数 / 除数 = 5/6

    // 5：被除数 6 除数


}
