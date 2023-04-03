package SortList

/**
 * Given the head of a linked list, return the list after sorting it in ascending order.
 *
 * Example 1:
 *
 * Input: head = [4,2,1,3]
 * Output: [1,2,3,4]
 *
 * Example 2:
 *
 *
 * Input: head = [-1,5,3,4,0]
 * Output: [-1,0,3,4,5]
 *
 * Example 3:
 *
 * Input: head = []
 * Output: []
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 5 * 104].
 * -105 <= Node.val <= 105
 */
fun main() {
    println(
        sortList(
            ListNode.convert(
                intArrayOf(
                    3,4,1
                )
            )
        )?.string().orEmpty()
    )
}

fun sortList(head: ListNode?): ListNode? {
    if (head?.next == null) {
        return head
    }

    fun merge(list1: ListNode?, list2: ListNode?): ListNode? {
        var l1 = list1
        var l2 = list2
        val l = ListNode(0)
        var p: ListNode? = l
        while (l1 != null && l2 != null) {
            if (l1.`val` < l2.`val`) {
                p!!.next = l1
                l1 = l1.next
            } else {
                p!!.next = l2
                l2 = l2.next
            }
            p = p.next
        }
        if (l1 != null) p!!.next = l1
        if (l2 != null) p!!.next = l2
        return l.next
    }

    var prev: ListNode? = null
    var slow = head
    var fast = head

    while (fast?.next != null) {
        prev = slow
        slow = slow?.next
        fast = fast.next?.next
    }

    prev?.next = null

    // step 2. sort each half
    val l1 = sortList(head)
    val l2 = sortList(slow)

    // step 3. merge l1 and l2
    return merge(l1, l2)
}

fun sortList1(head: ListNode?): ListNode? {
    if (head?.next == null) {
        return head
    }
    val result = ListNode(Int.MIN_VALUE)
    var p = head
    while (p != null) {
        var pr: ListNode? = result
        var pre: ListNode? = result
        while (pr != null && pr.`val` < p.`val`) {
            pre = pr
            pr = pr.next
        }
        if (pre!!.next == null) {
            pre.next = ListNode(p.`val`)
        } else {
            val next = pre.next
            val new = ListNode(p.`val`)
            pre.next = new
            new.next = next
        }

        p = p.next
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
            result = "$result${p.`val`},"
            p = p.next
        }
        return result
    }
}