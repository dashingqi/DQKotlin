package com.dashingqi.arithmetic.sort;

/**
 * 冒泡排序
 *
 * @author dashingqi
 * @since 2023/3/6
 */
public class BubbleSort {

    /**
     * 冒泡排序
     *
     * @param array 排序的数组
     * @return 排序后的数组
     */
    public static int[] bubbleSort(int[] array) {
        int length = array.length;
        if (length <= 1) return array;
        for (int i = 0; i < length; ++i) {
            boolean isBreak = false;
            for (int j = 0; j < length - i - 1; ++j) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    isBreak = true;
                }
            }
            if (!isBreak) break;
        }
        return array;
    }

    public static int[] bubbleSortOne(int[] array) {
        int length = array.length;
        if (length <= 1) return array;
        for (int i = 0; i < length; i++) {
            boolean flag = false;
            for (int j = 0; j < length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int tempValue = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tempValue;
                    flag = true;
                }
            }
            if (!flag) break;
        }

        return array;

    }
}
