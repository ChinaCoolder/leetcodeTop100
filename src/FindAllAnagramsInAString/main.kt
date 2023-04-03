package FindAllAnagramsInAString

/**
 * Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 *
 * Example 1:
 *
 * Input: s = "cbaebabacd", p = "abc"
 * Output: [0,6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 *
 * Input: s = "abab", p = "ab"
 * Output: [0,1,2]
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
fun main() {
    println(
        findAnagrams(
            "af",
            "be"
        )
    )
}

fun findAnagrams(s: String, p: String): List<Int> {
    val pFreq = IntArray(26)
    val sFreq = IntArray(26)
    val res = mutableListOf<Int>()

    // 统计p中各字符出现的频率
    for (c in p) {
        pFreq[c - 'a']++
    }

    // 维护一个长度为p.length的滑动窗口，在s中找出所有p的anagrams
    for (i in s.indices) {
        // 把新的字符加入到窗口中
        sFreq[s[i] - 'a']++
        // 把窗口最左侧的字符移除
        if (i >= p.length) {
            sFreq[s[i - p.length] - 'a']--
        }
        // 如果窗口内字符出现的频率和p中相同，则表示找到一个anagram
        if (i >= p.length - 1 && sFreq.contentEquals(pFreq)) {
            res.add(i - p.length + 1)
        }
    }

    return res
}