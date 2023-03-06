package com.dashingqi.arithmetic.sort;

/**
 * 插入排序
 * 一个有序的数组 插入元素
 *
 * @author dashingqi
 * @since 2023/3/6
 */
public class InsertSort {

    /**
     * 插入排序 是一个排序的方法
     *
     * @param a 数组
     */
    public static int[] insertSort(int[] a) {
        int length = a.length;
        if (length <= 1) return a;
        for (int i = 1; i < length; ++i) {
            int value = a[i];
            int j = i - 1;
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    a[j + 1] = a[j]; // 数据移动
                } else {
                    break;
                }
            }
            a[j + 1] = value; // 插入数据
        }
        return a;
    }
}
