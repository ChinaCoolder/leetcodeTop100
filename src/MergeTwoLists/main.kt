package MergeTwoLists

fun main() {
    println(
        mergeTwoLists(
            ListNode.convert(intArrayOf(1,2,4)),
            ListNode.convert(intArrayOf(1,3,4))
        )?.string().orEmpty()
    )
}

fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    val result = ListNode(0)
    var p = result
    var p1 = list1
    var p2 = list2
    while (p1 != null && p2 != null) {
        if (p1.`val` < p2.`val`) {
            p.next = p1
            p1 = p1.next
        } else {
            p.next = p2
            p2 = p2.next
        }
        p = p.next!!
    }
    if (p1 != null) {
        p.next = p1
    }
    if (p2 != null) {
        p.next = p2
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