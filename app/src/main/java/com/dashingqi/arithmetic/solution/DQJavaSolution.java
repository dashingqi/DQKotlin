package com.dashingqi.arithmetic.solution;

import com.dashingqi.arithmetic.listnode.ListNode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author : zhangqi
 * @desc : solution
 * @time : 2023/7/23 16:29
 */
public class DQJavaSolution {

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
                pre = tempValue;
            } else if (tempValue > 1) {
                maxCount = Math.max(maxCount, tempCount);
                pre = tempValue;
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
}
