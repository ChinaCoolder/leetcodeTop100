package MinimumWindowSubstring


/**
 * Given two strings s and t of lengths m and n respectively, return the minimum window
 * substring
 *  of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
 *
 * The testcases will be generated such that the answer is unique.
 *
 * Example 1:
 *
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 *
 * Example 2:
 *
 * Input: s = "a", t = "a"
 * Output: "a"
 * Explanation: The entire string s is the minimum window.
 *
 * Example 3:
 *
 * Input: s = "a", t = "aa"
 * Output: ""
 * Explanation: Both 'a's from t must be included in the window.
 * Since the largest window of s only has one 'a', return empty string.
 */

fun main() {
    println(
        minWindow("ADOBECODEBANC", "ABC")
    )
}

fun minWindow(s: String, t: String): String {
    if (s.isEmpty() || t.isEmpty() || s.length < t.length) {
        return ""
    }
    if (s == t) {
        return s
    }
    val map = hashMapOf<Char, Int>()
    t.toCharArray().forEach {
        map[it] = (map[it]?:0) + 1
    }

    var count = 0
    var left = 0
    var minLength = 0
    var minLeft = 0
    for (right in s.indices) {
        if (map.contains(s[right])) {
            map[s[right]] = (map[s[right]] ?: 1) - 1
            if ((map[s[right]]?:-1) >= 0) {
                count ++
            }
            while (count == t.length) {
                if (minLength == 0 || right - left + 1 < minLength) {
                    minLength = right - left + 1
                    minLeft = left
                }
                if (map.contains(s[left])) {
                    map[s[left]] = map[s[left]]!! + 1
                    if ((map[s[left]]?:0) > 0) {
                        count--
                    }
                }
                left ++
            }
        }
    }
    return if (minLength == 0) "" else s.substring(minLeft, minLeft + minLength)
}

fun minWindow1(s: String, t: String): String {
    var result = ""
    val map = hashMapOf<Char, Int>()
    val tMap = hashMapOf<Char, Int>()
    for (i in t.indices) {
        tMap[t[i]] = (tMap[t[i]] ?: 0) + 1
    }

    fun contain(): Boolean {
        for (i in t.indices) {
            if (
                map[t[i]] == null ||
                map[t[i]]!! < tMap[t[i]]!!
            ) {
                return false
            }
        }
        return true
    }

    var left = 0
    var right = 0
    while (right < s.length) {
        map[s[right]] = (map[s[right]] ?: 0) + 1
        if (!contain()) {
            right ++
        } else {
            val temp = s.substring(left, right + 1)
            if (result.isEmpty() || temp.length < result.length) {
                result = temp
            }
            map[s[left]] = (map[s[left]] ?: 0) - 1
            map[s[right]] = (map[s[right]] ?: 0) - 1
            left ++
        }
    }

    return result
}