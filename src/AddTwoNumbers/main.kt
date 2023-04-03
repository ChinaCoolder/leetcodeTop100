package AddTwoNumbers

fun main() {
    println(
        addTwoNumbers(
            ListNode.convert(intArrayOf(2, 4, 3)),
            ListNode.convert(intArrayOf(5, 6, 4))
        )?.string()
    )

    println(
        addTwoNumbers(
            ListNode(0),
            ListNode(0)
        )?.string()
    )

    println(
        addTwoNumbers(
            ListNode.convert(intArrayOf(9,9,9,9,9,9,9)),
            ListNode.convert(intArrayOf(9,9,9,9))
        )?.string()
    )
}

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    val head = ListNode(0)
    var p: ListNode? = head
    var p1 = l1
    var p2 = l2
    var add = 0
    while (p1 != null || p2 != null || add != 0) {
        val value = (p1?.`val`?:0) + (p2?.`val`?:0) + add
        add = value / 10
        p?.next = ListNode(value % 10)
        p = p?.next
        p1 = p1?.next
        p2 = p2?.next
    }
    return head.next
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
            result = "$result${p.`val`}"
            p = p.next
        }
        return result
    }
}