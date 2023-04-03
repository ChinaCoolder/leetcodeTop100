package LongestCommonPrefix

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 *
 * Constraints:
 *
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lowercase English letters.
 */
fun main() {
    println(
        longestCommonPrefix(
            arrayOf(
                "flower","flow","flight"
            )
        )
    )
}

fun longestCommonPrefix(strs: Array<String>): String {
    var common = strs[0]
    for (i in 1 until strs.size) {
        while (common.isNotEmpty()) {
            if (strs[i].startsWith(common)) {
                break
            }
            common = common.dropLast(1)
        }
        if (common.isEmpty()) {
            break
        }
    }
    return common
}