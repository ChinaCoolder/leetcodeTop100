package PalindromeLinkedList

/**
 * Given the head of a singly linked list, return true if it is a
 * palindrome
 *  or false otherwise.
 */

fun main() {
    println(
        isPalindrome(
            ListNode.convert(
                intArrayOf(
                    1,2,2,1,2
                )
            )
        )
    )
}

fun isPalindrome(head: ListNode?): Boolean {
    if (head?.next == null) {
        return true
    }
    val list = mutableListOf<Int>()
    var p = head
    while (p != null) {
        list.add(p.`val`)
        p = p.next
    }

    var start: Int = if(list.size % 2 == 1) list.size / 2 else list.size / 2 - 1
    var end : Int =  if(list.size % 2 == 1) list.size / 2 else list.size / 2
    while (start >= 0 && end <= list.lastIndex) {
        if (list[start] != list[end]) {
            return false
        }
        start --
        end ++
    }
    return true
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