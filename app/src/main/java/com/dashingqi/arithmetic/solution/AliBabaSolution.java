package com.dashingqi.arithmetic.solution;

import com.dashingqi.arithmetic.listnode.ListNode;

import java.util.HashMap;

/**
 * 阿里巴巴算法复习题
 *
 * @author : zhangqi
 * @desc : fuck
 * @time : 2023/8/6 09:47
 */
class AliBabaSolution {

    /**
     * 两数之和
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        // 1.边界条件
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        // 声明存储结构
        HashMap<Integer, Integer> maps = new HashMap<>();
        // 长度
        int len = nums.length;

        // 3. 循环获取
        for (int i = 0; i < len; i++) {
            int key = nums[i];
            int result = target - key;
            // 3.1 如果有合适的值作为 key 进行存储，就进行获取 返回数组
            if (maps.containsKey(result)) {
                return new int[]{maps.get(result), i};

            } else {
                // 3.2 没有合适的值存储，就进行存储
                maps.put(key, i);
            }
        }
        return new int[0];
    }

    /**
     * 两数想加
     *
     * @param l1 链表 1
     * @param l2 链表 2
     * @return result listNode
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 1. 声明变量
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0; // 进位
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            // 计算两数之和 + 进位
            int sum = x + y + carry;
            // 计算进位
            carry = sum / 10;
            // 计算余数
            sum = sum % 10;
            // 存储值
            cur.next = new ListNode(sum);
            // 移动角标
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
        return pre.next;
    }

    /**
     * 无重复最长子串
     *
     * @param s 字符串
     * @return 无重复子串长度
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int ans = 0;
        HashMap<Character, Integer> maps = new HashMap<>();
        for (int end = 0, start = 0; end < len; end++) {
            char value = s.charAt(end);

            if (maps.containsKey(value)) {
                int curIndex = maps.get(value);
                // 存储的 value 已经+1 过
                start = Math.max(start, curIndex);
            }

            ans = Math.max(ans, end - start + 1);
            // 求得是长度+1
            maps.put(value, end + 1);
        }
        return ans;

    }
}
