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
}