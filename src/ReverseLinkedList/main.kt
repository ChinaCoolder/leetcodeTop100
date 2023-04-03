package ReverseLinkedList

/**
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 *
 * Example 1:
 *
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 *
 * Example 2:
 *
 * Input: head = [1,2]
 * Output: [2,1]
 *
 * Example 3:
 *
 * Input: head = []
 * Output: []
 *
 * Constraints:
 *
 * The number of nodes in the list is the range [0, 5000].
 * -5000 <= Node.val <= 5000
 */
fun main() {
    println(
        reverseList(
            ListNode.convert(
                intArrayOf(1,2,3,4,5)
            )
        )?.string().orEmpty()
    )
}

fun reverseList(head: ListNode?): ListNode? {
    var pre: ListNode? = null
    var p: ListNode? = head
    while (p != null) {
        val temp = p.next
        p.next = pre
        pre = p
        p = temp
    }
    return pre
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