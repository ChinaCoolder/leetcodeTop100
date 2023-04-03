package RemoveNthFromEnd

fun main() {
    println(
        removeNthFromEnd(ListNode.convert(intArrayOf(1,2)), 1)?.string().orEmpty()
    )
}

fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    if (n == 1 && head?.next == null) {
        return null
    }
    var p1 = head
    var p2 = head
    var pre = ListNode(0).apply {
        next = head
    }
    var nVal = n
    while (nVal > 1) {
        p2 = p2?.next
        nVal --
    }
    var usePre = true
    while (p2?.next != null) {
        usePre = false
        pre = p1!!
        p1 = p1.next
        p2 = p2.next
    }
    pre.next = pre.next?.next
    return if (usePre) pre.next else head
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