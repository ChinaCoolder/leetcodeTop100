package SwapNodesInPairs

/**
 * Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
 *
 * Example 1:
 *
 * Input: head = [1,2,3,4]
 * Output: [2,1,4,3]
 *
 * Example 2:
 *
 * Input: head = []
 * Output: []
 *
 * Example 3:
 *
 * Input: head = [1]
 * Output: [1]
 *
 */
fun main() {
    println(
        swapPairs(
            ListNode.convert(
                intArrayOf(
                    1,2,3,4
                )
            )
        )?.string().orEmpty()
    )
}

fun swapPairs(head: ListNode?): ListNode? {
    if (head?.next == null) {
        return head
    }
    var p1 = head
    var p2 = head.next
    while (p1 != null && p2 != null) {
        val prepare = p2.next
        val temp = p1.`val`
        p1.`val` = p2.`val`
        p2.`val` = temp
        p1 = prepare
        p2 = prepare?.next
    }
    return head
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