package com.dashingqi.arithmetic.solution;

import com.dashingqi.arithmetic.listnode.ListNode;

import java.util.HashMap;

/**
 * @author zhangqi61
 * @since 2023/8/7
 */
public class StringSolution {

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

    /**
     * 找出字符串中第一个匹配项的下标
     *
     * @param haystack 原始字符串
     * @param needle   匹配项目
     * @return 角标
     */
    public int strStr(String haystack, String needle) {
        // 1. 边界条件
        if (haystack.isEmpty() || needle.isEmpty()) {
            return -1;
        }

        int m = haystack.length(), n = needle.length();
        char[] s = haystack.toCharArray(), p = needle.toCharArray();
        for (int i = 0; i <= m - n; i++) {
            int a = i, b = 0;
            while (b < m && s[a] == p[b]) {
                a++;
                b++;
            }
            if (b == m) return i;
        }

        return -1;
    }

    /**
     * 检查链表中是否存在环
     *
     * @param head 链表头节点
     * @return true/false
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;

        }
        return true;
    }

}
