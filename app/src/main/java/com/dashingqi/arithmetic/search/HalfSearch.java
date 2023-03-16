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
     *
     * @param array 数据源
     * @param low   左角标
     * @param high  右角标
     * @param value 目标值
     * @return index
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

    /**
     * 查找最后一个值等于给定值的元素
     *
     * @param array 数据源
     * @param low   左角标
     * @param high  右角标
     * @param value 目标值
     * @return index
     */
    private static int bSearchLastValueInternally(int[] array, int low, int high, int value) {
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (array[mid] > value) {
                high = mid - 1;
            } else if (array[mid] < value) {
                low = mid + 1;
            } else {
                // 首先保证角标或者保证是最后一个值；
                if (mid == array.length - 1 || array[mid + 1] != value) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }


    /**
     * 查找第一个值大于给定值的元素
     *
     * @param array 数据源
     * @param low   左角标
     * @param high  右角标
     * @param value 目标值
     * @return index
     */
    private static int bSearchFirstMaxValueInternally(int[] array, int low, int high, int value) {
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (array[mid] > value) {
                if (mid == 0 || array[mid - 1] < value) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 查找最后一个小于给定值的元素
     *
     * @param array 数据源
     * @param low   左角标
     * @param high  右角标
     * @param value 目标值
     * @return index
     */
    private static int bSearchLastMinValueInternally(int[] array, int low, int high, int value) {
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (array[mid] > value) {
                high = mid - 1;
            } else {
                if (mid == array.length - 1 || array[mid + 1] > value) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }
}
