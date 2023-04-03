package PalindromePartitioning

import java.util.LinkedList

/**
 * Given a string s, partition s such that every
 * substring
 *  of the partition is a
 * palindrome
 * . Return all possible palindrome partitioning of s.
 *
 * Example 1:
 *
 * Input: s = "aab"
 * Output: [["a","a","b"],["aa","b"]]
 *
 * Example 2:
 *
 * Input: s = "a"
 * Output: [["a"]]
 */
fun main() {
    println(
        partition(
            "aab"
        )
    )
}

fun partition(s: String): List<List<String>> {
    val result = mutableListOf<List<String>>()

    fun isPalindrome(str: String): Boolean {
        var left = 0
        var right = str.lastIndex
        if (left == right) return true
        while (left < right) {
            if (str[left] != str[right]) return false
            left++
            right--
        }
        return true
    }

    fun track(p: Int, list: LinkedList<String>) {
        if (p >= s.length) {
            result.add(list.toList())
            return
        }
        for (i in p .. s.lastIndex) {
            val string = s.substring(p, i + 1)
            if (isPalindrome(string)) {
                list.add(string)
                track(i + 1, list)
                list.removeLast()
            }
        }
    }
    track(0, LinkedList())
    return result
}