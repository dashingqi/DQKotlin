package com.dashingqi.arithmetic.bytedance;

import com.dashingqi.arithmetic.listnode.ListNode;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * 按照出现的频率
 *
 * @author zhangqi61
 * @since 2023/8/10
 */
public class ByteDSolution {


    /**
     * 两数相加(1)
     * 主要是先取进位，用于下次两链表相加时所用；默认是0
     * 然后取余数，余数是当前链表的节点
     *
     * @param l1 链表 1
     * @param l2 链表 2
     * @return 链表 3
     */
    public ListNode addToNumbers(ListNode l1, ListNode l2) {

        // 声明变量 保存进位
        int carry = 0;
        int d = 1;
        int c = 2;
        int e = 4;
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;
            // 取进位
            carry = sum / 10;
            // 进行取余数运算，小于10是本身 ，大于10余数
            sum = sum % 10;
            cur.next = new ListNode(sum);
            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry == 1) {
            cur.next = new ListNode(carry);
        }
        return cur;
    }

    /**
     * 两数之和(2)
     *
     * @param nums   数组
     * @param target 和
     * @return 角标数组
     */
    public int[] twoSum(int[] nums, int target) {
        // 边界条件
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int len = nums.length;

        HashMap<Integer, Integer> maps = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int key = target - nums[i];
            if (maps.containsKey(key)) {
                int index = maps.get(key);
                return new int[]{index, i};
            } else {
                maps.put(nums[i], i);
            }
        }
        return new int[0];
    }

    /**
     * （3）
     * 最长无重复子串
     *
     * @param s 字符串
     * @return 无重复子串长度
     */
    public int lengthOfLongestSubstring(String s) {
        // 边界条件
        if (s == null || s.length() == 0) {
            return 0;
        }
        int strLen = s.toCharArray().length;
        HashMap<Character, Integer> maps = new HashMap<>();
        int start = 0, end = 0;
        int maxLen = 0;
        for (; end < strLen; end++) {
            char value = s.charAt(end);
            if (maps.containsKey(value)) {
                int index = maps.get(value);
                start = Math.max(start, index);
            }
            maxLen = Math.max(maxLen, end - start + 1);
            maps.put(value, end + 1);
        }
        return maxLen;
    }

    /**
     * （6）
     * 最长回文字符串
     *
     * @param s 字符串
     * @return 最长的回文串
     */
    public String longestPalindrome(String s) {
        // 边界条件
        if (s.isEmpty()) return "";
        return "";

    }


    /**
     * （9）
     * 反转链表
     *
     * @param head 链表
     * @return 反转后链表
     */
    public ListNode reverseList(ListNode head) {

        if (head == null) return null;
        if (head.next == null) return head;

        ListNode cur = null;
        ListNode pre = head;
        while (pre != null) {
            ListNode tempNode = pre.next;
            pre.next = cur;
            cur = pre;
            pre = tempNode;
        }
        return cur;
    }
}

/**
 * LRU 缓存 （5）
 */
class LRUCache {

    private LinkedHashMap<Integer, Integer> maps;
    private int capacity;

    public LRUCache(int capacity) {
        maps = new LinkedHashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        if (maps.containsKey(key)) {
            int value = maps.remove(key);
            maps.put(key, value);
            return value;
        }



        return -1;

    }

    public void put(int key, int value) {
        if (maps.containsKey(key)) {
            maps.remove(key);
            maps.put(key, value);
            return;
        }
        maps.put(key, value);
        if (maps.size() > capacity) {
            maps.remove(maps.keySet().iterator().next());
        }
    }
}
