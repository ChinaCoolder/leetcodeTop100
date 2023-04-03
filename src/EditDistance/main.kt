package EditDistance

/**
 * Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
 *
 * You have the following three operations permitted on a word:
 *
 * Insert a character
 * Delete a character
 * Replace a character
 *
 * Example 1:
 *
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 *
 * Example 2:
 *
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation:
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 *
 * Constraints:
 *
 * 0 <= word1.length, word2.length <= 500
 * word1 and word2 consist of lowercase English letters.
 */

fun main() {
    println(
        minDistance(
            "intention",
            "execution"
        )
    )
}

fun minDistance(word1: String, word2: String): Int {
    if (word1.isEmpty() || word2.isEmpty()) {
        return word1.length.coerceAtLeast(word2.length)
    } else {
        val map = Array(word1.length + 1){ IntArray(word2.length + 1) }
        for (i in 1 .. word1.length) {
            map[i][0] = i
        }
        for (i in 1 .. word2.length) {
            map[0][i] = i
        }
        for (i in 1 .. word1.length) {
            for (j in 1 .. word2.length) {
                if (word1[i - 1] == word2[j - 1]) {
                    map[i][j] = map[i - 1][j - 1]
                } else {
                    map[i][j] = Math.min(Math.min(map[i - 1][j - 1], map[i][j - 1]), map[i - 1][j]) + 1
                }
            }
        }
        return map[word1.length][word2.length]
    }
}