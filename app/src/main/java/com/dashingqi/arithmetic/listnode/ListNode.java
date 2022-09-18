package com.dashingqi.arithmetic.listnode;

/**
 * @author : zhangqi
 * @desc :
 * @time : 2022/9/18 15:51
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
