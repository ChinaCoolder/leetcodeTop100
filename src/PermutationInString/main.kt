package PermutationInString

/**
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 *
 * In other words, return true if one of s1's permutations is the substring of s2.
 *
 *
 *
 * Example 1:
 *
 * Input: s1 = "ab", s2 = "eidbaooo"
 * Output: true
 * Explanation: s2 contains one permutation of s1 ("ba").
 * Example 2:
 *
 * Input: s1 = "ab", s2 = "eidboaoo"
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= s1.length, s2.length <= 104
 * s1 and s2 consist of lowercase English letters.
 */
fun main() {
    println(
        checkInclusion(
            "ab",
            "eidbaooo"
        )
    )
}

fun checkInclusion(s1: String, s2: String): Boolean {
    val pFreq = IntArray(26)
    val sFreq = IntArray(26)
    // 统计p中各字符出现的频率
    for (c in s1) {
        pFreq[c - 'a']++
    }

    // 维护一个长度为p.length的滑动窗口，在s中找出所有p的anagrams
    for (i in s2.indices) {
        // 把新的字符加入到窗口中
        sFreq[s2[i] - 'a']++
        // 把窗口最左侧的字符移除
        if (i >= s1.length) {
            sFreq[s2[i - s1.length] - 'a']--
        }
        // 如果窗口内字符出现的频率和p中相同，则表示找到一个anagram
        if (i >= s1.length - 1 && sFreq.contentEquals(pFreq)) {
            return true
        }
    }

    return false
}