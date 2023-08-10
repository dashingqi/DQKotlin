package com.dashingqi.arithmetic.listnode;

/**
 * @author : zhangqi
 * @desc :
 * @time : 2022/9/18 15:51
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
