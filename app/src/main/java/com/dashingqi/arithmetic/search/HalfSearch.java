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

    /**
     * 查找第一个值等于给定值的元素
     * @param array
     * @param low
     * @param high
     * @param value
     * @return
     */
    private static int bSearchFirstValueInternally(int[] array, int low, int high, int value) {
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (array[mid] > value) {
                high = mid - 1;
            } else if (array[mid] < value) {
                low = mid + 1;
            } else {
                if ((mid == 0) || (array[mid - 1] != value)) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
