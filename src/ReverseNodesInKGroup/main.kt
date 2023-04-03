package ReverseNodesInKGroup

import java.util.Stack

/**
 * Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
 *
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
 *
 * You may not alter the values in the list's nodes, only nodes themselves may be changed.
 *
 * Example 1:
 *
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [2,1,4,3,5]
 *
 * Example 2:
 *
 * Input: head = [1,2,3,4,5], k = 3
 * Output: [3,2,1,4,5]
 *
 * Constraints:
 *
 * The number of nodes in the list is n.
 * 1 <= k <= n <= 5000
 * 0 <= Node.val <= 1000
 */
fun main() {
    println(
        reverseKGroup(
            ListNode.convert(
                intArrayOf(
                    1,2,3,4,5
                )
            ),
            2
        )?.string().orEmpty()
    )
}

fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
    if (head?.next == null) {
        return head
    }
    var p1 = head
    var p2 = head

    val result = ListNode(0)
    var pr: ListNode? = result

    while (p1 != null && p2 != null) {
        for (i in 1 until k) {
            p2 = p2?.next
        }
        if (p2 != null) {
            val prepare = p2.next

            val stack = Stack<ListNode?>()
            var pp = p1
            while (pp != prepare) {
                val next = pp?.next
                pp?.next = null
                stack.push(pp)
                pp = next
            }

            while (stack.isNotEmpty()) {
                pr?.next = stack.pop()
                pr = pr?.next
            }

            p1 = prepare
            p2 = prepare
        } else {
            pr?.next = p1
        }
    }
    return result.next
}

class ListNode(var `val`: Int) {
    companion object {
        fun convert(nums: IntArray): ListNode? {
            if (nums.isEmpty()) {
                return null
            }
            val head = ListNode(0)
            var p: ListNode? = head
            nums.forEach {
                p?.next = ListNode(it)
                p = p?.next
            }
            return head.next
        }
    }

    var next: ListNode? = null

    fun string(): String {
        var result = ""
        var p: ListNode? = this
        while (p != null) {
            result = "$result${p.`val`}，"
            p = p.next
        }
        return result
    }
}