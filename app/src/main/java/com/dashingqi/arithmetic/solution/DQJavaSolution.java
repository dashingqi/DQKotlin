package com.dashingqi.arithmetic.solution;

import android.text.TextUtils;

import com.dashingqi.arithmetic.listnode.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author : zhangqi
 * @desc : solution
 * @time : 2023/7/23 16:29
 */
public class DQJavaSolution {

    /**
     * 十进制转换成二进制
     *
     * @param num 十进制数值
     * @return 二进制字符串
     */
    public static String decimalToBinaryOne(int num) {
        if (num == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();

        while (num > 0) {

            sb.insert(0, num % 2);
            num /= 2;

        }

        return sb.toString();
    }


    /**
     * 买卖股票最佳时机
     *
     * @param prices nums
     * @return 最大的利润
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int minPrice = Integer.MAX_VALUE;
        int maxPrice = 0;
        for (int price : prices) {
            if (minPrice > price) {
                minPrice = price;
            } else if (price - minPrice > maxPrice) {
                maxPrice = price - minPrice;
            }
        }
        return maxPrice;
    }

    /**
     * 两数之和
     *
     * @param nums   数组
     * @param target 之和
     * @return 角标数组
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums == null) {
            return new int[]{};
        }

        HashMap<Integer, Integer> maps = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int otherValue = target - nums[i];
            if (maps.containsKey(otherValue)) {
                return new int[]{maps.get(otherValue), i};
            }
            maps.put(nums[i], i);
        }
        return new int[]{};
    }

    /**
     * 最长连续序列
     *
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -0;
        }
        Arrays.sort(nums);
        int maxCount = 0;
        int tempCount = 1;
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tempValue = nums[i] - pre;
            if (tempValue == 1) {
                tempCount++;
                pre = nums[i];
            } else if (tempValue > 1) {
                maxCount = Math.max(maxCount, tempCount);
                pre = nums[i];
                tempCount = 1;
            } else {
                // do nothing
            }
        }
        return Math.max(maxCount, tempCount);
    }

    /**
     * 数组中第K 大元素
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);
        int result = nums.length;
        while (k != 0) {
            k--;
            result--;
        }
        return nums[result + 1];
    }

    /**
     * 10 进制转换成 2 进制
     *
     * @param decimalNumber 10 进制数字
     * @return 二进制字符串
     */
    public static String decimalToBinary(int decimalNumber) {
        if (decimalNumber == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while (decimalNumber > 0) {
            int num = decimalNumber % 2;
            sb.insert(0, num);
            decimalNumber = decimalNumber / 2;
        }
        return sb.toString();
    }

    /**
     * <<<<<<< HEAD
     * 三数之和
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> sums = new ArrayList<>();
        //1. 边界条件
        if (nums == null || nums.length < 3) {
            return sums;
        }

        // 2 进行排序
        Arrays.sort(nums);
        // 长度
        int len = nums.length;
        // 3. 循环遍历计算求和
        for (int i = 0; i < len; i++) {
            // 3.1
            if (nums[i] > 0) {
                break;
            }
            // 3.2 去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 3.3 双指针
            int L = i + 1;
            int R = len - 1;

            //3.4 真正计算求和
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    sums.add(Arrays.asList(nums[i], nums[L], nums[R]));
                } else if (sum < 0) {
                    L++;
                } else {
                    R--;
                }
            }
        }
        return sums;
    }

    /**
     * 罗马数字转换成整数
     *
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        // 1. 边界条件
        if (TextUtils.isEmpty(s)) {
            return 0;
        }

        // 2.存储映射关系
        HashMap<Character, Integer> maps = new HashMap<Character, Integer>() {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};


        // 2.1 字符串长度
        int len = s.length();
        int sum = 0;
        int preNum = maps.get(s.charAt(0));
        // 3 循环遍历获取值
        for (int i = 1; i < len; i++) {
            int currentNum = maps.get(s.charAt(i));
            if (preNum < currentNum) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = currentNum;
        }
        sum += preNum;
        return sum;
    }
}
