package com.dashingqi.arithmetic.sort;

import android.util.Log;

import java.util.Arrays;

/**
 * @author dashingqi
 * @since 2023/3/6
 */
public class QuickSort {
    private static final String TAG = "QuickSort";

    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = partition(arr, left, right); // 选取枢轴，并将数组划分为左右两个子数组
        quickSort(arr, left, pivot - 1); // 对左子数组递归排序
        quickSort(arr, pivot + 1, right); // 对右子数组递归排序

        Log.d(TAG, "quickSort arr = " + Arrays.toString(arr));
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[left]; // 选取第一个元素为枢轴
        int i = left + 1, j = right;
        while (i <= j) {
            while (i <= j && arr[i] < pivot) { // 从左往右找到第一个大于等于枢轴的元素
                i++;
            }
            while (i <= j && arr[j] >= pivot) { // 从右往左找到第一个小于枢轴的元素
                j--;
            }
            if (i < j) { // 交换左右两个元素
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        arr[left] = arr[j]; // 将枢轴放到正确的位置上
        arr[j] = pivot;
        return j; // 返回枢轴的下标
    }
}
