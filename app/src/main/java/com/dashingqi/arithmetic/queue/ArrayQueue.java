package com.dashingqi.arithmetic.queue;

import androidx.annotation.Nullable;

/**
 * @author : zhangqi
 * @desc :
 * @time : 2023/2/21 22:42
 */
public class ArrayQueue {

    private String[] items;
    private int n;
    // 对头下标
    private int head = 0;
    // 对尾下标
    private int tail = 0;

    public ArrayQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    /**
     * 入队
     *
     * @return 是否成功
     */
    public boolean enqueue(String item) {
        // 如果队尾下标==n说明队列已经满了
        if (tail == n) {
            if (head == 0) {
                return false;
            }
            for (int i = head; i < tail; ++i) {
                items[i - head] = items[i];
            }

            // 更新tail和head
            tail -= head;
            head = 0;
        }
        items[tail] = item;
        ++tail;
        return true;
    }

    /**
     * 出队
     *
     * @return 元素
     */
    @Nullable
    public String dequeue() {
        // 说明此时队列已经空了
        if (head == tail) return null;
        String item = items[head];
        ++head;
        return item;
    }
}
