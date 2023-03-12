package com.dashingqi.arithmetic.search;

/**
 * @author : zhangqi
 * @desc : 二分查找
 * @time : 2023/3/11 10:16
 */
public class HalfSearch {

    public static int bSearch(int[] array, int length, int value) {
        return bSearchInternally(array, 0, length - 1, value);
    }

    private static int bSearchInternally(int[] array, int low, int high, int value) {
        if (low > high) return -1;
        int mid = low + ((high - low) >> 1);
        if (array[mid] == value) {
            return mid;
        } else if (array[mid] < value) {
            return bSearchInternally(array, mid + 1, high, value);
        } else {
            return bSearchInternally(array, low, mid - 1, value);
        }
    }
}
