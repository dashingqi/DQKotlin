package com.dashingqi.arithmetic.listnode;

/**
 * @author : zhangqi
 * @desc :
 * @time : 2022/9/18 15:50
 */
class ListNodeSolution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while (l1 != null || l2 != null) {

            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;

            int sum = x + y + carry;

            carry = sum / 10;

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

        return pre.next;
    }

    /**
     * 反转链表
     *
     * @param head
     * @return 反转后的链表
     */
    public ListNode reverseList(ListNode head) {
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

    public ListNode reverseListNode(ListNode head) {
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

    public ListNode reverseListNode1(ListNode head) {
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

    public ListNode reverseListNode2(ListNode head) {
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

    public ListNode reverseListNode3(ListNode head) {
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

    public ListNode reverseListNode4(ListNode head) {
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

    public ListNode reverseListNode5(ListNode head) {
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
