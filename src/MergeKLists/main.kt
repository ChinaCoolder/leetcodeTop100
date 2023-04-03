package MergeKLists

fun main() {
    println(
        mergeKLists(
            arrayOf(
                null,
                ListNode.convert(intArrayOf(-1, 5, 11)),
                null,
                ListNode.convert(intArrayOf(6, 10))
            )
        )?.string().orEmpty()
    )
}

fun mergeKLists(lists: Array<ListNode?>): ListNode? {
    val head = ListNode(Int.MIN_VALUE)
    var pHead: ListNode? = head
    for (i in lists.indices) {
        var p: ListNode? = lists[i]
        while (p != null) {
            var pre: ListNode? = null
            while (pHead?.next != null && p.`val` > pHead.`val`) {
                pre = pHead
                pHead = pHead.next
            }
            if (p.`val` >= pHead!!.`val`) {
                val temp = pHead.next
                pHead.next = ListNode(p.`val`).apply {
                    next = temp
                }
            } else {
                pre!!.next = ListNode(p.`val`).apply {
                    next = pHead
                }
            }
            pHead = head
            p = p.next
        }
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
            result = "$result${p.`val`}，"
            p = p.next
        }
        return result
    }
}