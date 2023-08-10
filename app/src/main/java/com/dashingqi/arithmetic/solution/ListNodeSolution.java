package com.dashingqi.arithmetic.solution;

import com.dashingqi.arithmetic.listnode.ListNode;

/**
 * @author zhangqi61
 * @since 2023/8/7
 */
public class ListNodeSolution {

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
}
