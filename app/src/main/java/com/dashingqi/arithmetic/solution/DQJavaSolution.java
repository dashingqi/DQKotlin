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
     * 无重复最长子串长度
     *
     * @param s 字串
     * @return length
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int length = s.length();
        HashMap<Character, Integer> maps = new HashMap<>();
        int maxCount = 1;
        for (int start = 0, end = 0; end < length; end++) {
            char endValue = s.charAt(end);
            if (maps.containsKey(endValue)) {
                start = Math.max(start, maps.get(endValue) + 1);
            }
            maxCount = Math.max(maxCount, end - start + 1);
            maps.put(endValue, end);
        }

        return maxCount;

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
     * 链表的反转
     *
     * @param head 链表
     * @return reverse ListNode
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode pre = head;
        ListNode cur = null;
        while (pre != null) {
            ListNode tempNode = pre.next;
            pre.next = cur;
            cur = pre;
            pre = tempNode;
        }
        return cur;

    }

    /**
     * 最长递增字串长度
     *
     * @param nums 字符串
     * @return 长度
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dps = new int[nums.length];
        dps[0] = 1;
        int maxLength = 1;
        for (int i = 1; i < nums.length; i++) {
            dps[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dps[i] = Math.max(dps[i], dps[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, dps[i]);
        }
        return maxLength;
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
     * 相交链表的节点
     *
     * @param headA 链表 A
     * @param headB 链表 B
     * @return 相交的链表
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode hA = headA;
        ListNode hB = headB;
        while (hA != hB) {
            hA = hA == null ? headA : hA.next;
            hB = hB == null ? headB : hB.next;
        }

        return hA;

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

    /**
     * 给出一个链表，删除倒数第 n 个节点
     *
     * @param head 链表
     * @param n    倒数第几个
     * @return 目标链表
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 1. 边界条件判断
//        if (head == null || head.next == null) {
//            return head;
//        }
        // 2. 预指针
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode start = pre, end = pre;
        //  3.让 start 指针先走 n 步骤
        while (n > 0) {
            start = start.next;
            n--;
        }

        // 4. 走 start 和 end
        while (start.next != null) {
            start = start.next;
            end = end.next;
        }

        // 5. 返回end.next 就是要移除的节点
        end.next = end.next.next;
        // 返回结果链表
        return pre.next;
    }

    /**
     * 字符串转成数字
     *
     * @param s 字符串
     * @return 数字
     */
    public int myAtoi(String s) {
        // 1.边界条件
        if (s == null || s.length() == 0) {
            return 0;
        }

        int length = s.length();
        int index = 0;
        int sign = 1;
        int result = 0;

        // 2. 去除' '
        while (index < length && s.charAt(index) == ' ') {
            index++;
        }

        // 3. 匹配正负数
        if (index < length && (s.charAt(index) == '-' || s.charAt(index) == '+')) {
            sign = s.charAt(index) == '-' ? -1 : 1;
        }

        // 字符转整数
        while (index < length && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            result = result * 10 + digit;
            index++;
        }


        return result * sign;
    }
}
