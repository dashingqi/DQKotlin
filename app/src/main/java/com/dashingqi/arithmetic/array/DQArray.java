package com.dashingqi.arithmetic.array;

/**
 * @author zhangqi61
 * @since 2023/9/15
 */
public class DQArray {

    /**
     * 数组
     */
    private int[] array;

    /**
     * 数组的大小
     */
    private int size;

    /**
     * 构造函数
     *
     * @param capacity 容量
     */
    public DQArray(int capacity) {
        this.array = new int[capacity];
        this.size = 0;
    }


    /**
     * 数组的插入
     *
     * @param index 角标
     * @param value 值
     */
    public void insert(int index, int value) throws Exception {

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("out of index --> " + index);
        }

        if (size >= array.length) {
            // 进行扩容
            reSize();
        }

        for (int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }

        array[index] = value;

        size++;
    }

    /**
     * 删除角标
     *
     * @param index 角标
     * @return 对应的值
     * @throws Exception 抛出的异常
     */
    public int delete(int index) throws Exception {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("out of index --> " + index);
        }
        int value = array[index];
        for (int i = index; i < size - 1; i++) {
            array[index] = array[index + 1];
        }
        size--;
        return value;
    }

    /**
     * 扩容
     */
    public void reSize() {
        // 两部扩容
        int[] arrayNew = new int[array.length * 2];
        System.arraycopy(array, 0, arrayNew, 0, array.length);
        array = arrayNew;
    }
}
