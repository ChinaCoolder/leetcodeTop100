package PartitionLabels

/**
 * You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part.
 *
 * Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.
 *
 * Return a list of integers representing the size of these parts.
 *
 * Example 1:
 *
 * Input: s = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.
 * Example 2:
 *
 * Input: s = "eccbbbbdec"
 * Output: [10]
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 500
 * s consists of lowercase English letters.
 */
fun main() {
    println(
        partitionLabels(
            "ababcbacadefegdehijhklij"
        )
    )
}

fun partitionLabels(s: String): List<Int> {
    val result = mutableListOf<Int>()
    val array = IntArray(26){0}
    s.forEach {
        array[it - 'a'] ++
    }
    val list = mutableListOf<Char>()
    for (c in s) {
        list.add(c)
        array[c - 'a'] --
        var isAllClear = true
        for (value in list) {
            if (array[value - 'a'] != 0) {
                isAllClear = false
                break
            }
        }
        if (isAllClear) {
            result.add(list.size)
            list.clear()
        }
    }

    return result.takeIf { it.isNotEmpty() }?: listOf(s.length)
}