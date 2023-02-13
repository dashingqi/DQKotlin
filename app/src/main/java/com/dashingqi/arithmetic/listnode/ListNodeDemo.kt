package com.dashingqi.arithmetic.listnode

/**
 * @desc :
 * @author : zhangqi
 * @time : 2023/2/9 22:28
 */
class ListNodeDemo {

    /**
     * 链表的反转
     * @param head ListNode
     * @return ListNode?
     */
    internal fun reverseListNode(head: ListNode?): ListNode? {
        var cur: ListNode? = null
        var pre: ListNode? = head
        while (pre != null) {
            val tempNode = pre.next
            pre.next = cur
            cur = pre
            pre = tempNode
        }
        return cur
    }

    internal fun reverseListNode2(head: ListNode): ListNode? {
        var cur: ListNode? = null
        var pre: ListNode? = head
        while (pre != null) {
            val tempNode = pre.next
            pre.next = cur
            cur = pre
            pre = tempNode
        }

        return cur
    }

    /**
     * 环形链表 通过快慢指针
     * @param head ListNode?
     * @return Boolean
     */
    internal fun hasCycle(head: ListNode?): Boolean {
        head ?: return false
        head.next ?: return false
        var fast = head
        var slow = head
        while (fast?.next != null) {
            fast = fast.next?.next
            slow = slow?.next
            if (fast == slow) {
                return true
            }
        }
        return false
    }

    internal fun hasCycle1(head: ListNode?): Boolean {
        head ?: return false
        head.next ?: return false
        var fast: ListNode? = head
        var slow: ListNode? = head
        while (fast?.next != null) {
            fast = fast.next?.next
            slow = slow?.next
            if (fast == slow) {
                return true
            }
        }
        return false
    }

    /**
     * 合并两个有序链表
     * @param list1 ListNode?
     * @param list2 ListNode?
     * @return ListNode?
     */
//    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
//        list1 ?: return list2
//        list2 ?: return list1
//
//    }

    /**
     * 求出链表的中间结点
     * @param head ListNode? 头结点
     * @return ListNode? 中间结点
     * 使用快慢指针的思想，一个走一个结点，一个走两个结点 当快结点走完时 此时慢结点就走到中间结点了
     */
    fun middleNode(head: ListNode?): ListNode? {
        var fastNode = head
        var slowNode = head
        while (fastNode?.next != null) {
            fastNode = fastNode.next?.next
            slowNode = slowNode?.next
        }

        return slowNode
    }
}