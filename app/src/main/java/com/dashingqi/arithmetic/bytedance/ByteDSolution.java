package com.dashingqi.arithmetic.bytedance;

import com.dashingqi.arithmetic.listnode.ListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

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

    /**
     * 整数反转
     *
     * @param num
     * @return
     */
    public int reverseInt(int num) {
        int total = 0;
        while (num != 0) {
            int capacity = num % 10;
            if (num > Integer.MAX_VALUE) {
                return 0;
            }
            if (num < -Integer.MAX_VALUE) {
                return 0;
            }
            total = total * 10 + capacity;

            num = num / 10;
        }
        return total;
    }

    /**
     * 查找重复的数字
     *
     * @param nums 数字集合
     * @return 查找的数字
     */
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return -1;
    }

    /**
     * 有效的括号
     *
     * @param s 括号字符串
     * @return 是否是有效括号
     */
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }

        Map<Character, Character> maps = new HashMap<Character, Character>() {{
            put('(', ')');
            put('{', '}');
            put('[', ']');
            put('?', '?');
        }};

        if (!maps.containsKey(s.charAt(0))) {
            return false;
        }

        LinkedList<Character> lists = new LinkedList<>();
        lists.add('?');
        for (char tempValue : s.toCharArray()) {
            if (maps.containsKey(tempValue)) {
                // 存储 Value
                lists.addLast(maps.get(tempValue));
            } else if (lists.removeLast() != tempValue) {
                return false;
            }
        }
        return lists.size() == 1;
    }

    /**
     * 检查是否有环
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != slow) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
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

/**
 * 两个栈实现队列
 */
class CQueue {
    public CQueue() {
    }

    Stack<Integer> in = new Stack<>();

    Stack<Integer> out = new Stack<>();

    public void appendTail(int value) {
        in.push(value);
    }

    public int deleteHead() {
        if (out.isEmpty()) {
            if (in != null && !in.isEmpty()) {
                in2Out();
            } else {
                return -1;
            }
        }
        return out.pop();
    }

    public void in2Out() {
        while (!in.isEmpty()) {
            out.push(in.pop());
        }
    }
}
