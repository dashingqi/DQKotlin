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

            carry = sum / 10; // 1

            sum = sum % 10; // 2

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

    /**
     * 合并两个有序的链表
     *
     * @param list1 链表1
     * @param list2 链表2
     * @return 合并后的链表
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}
