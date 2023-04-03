package PascalsTriangle

/**
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 *
 * Example 1:
 *
 * Input: numRows = 5
 * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 *
 * Example 2:
 *
 * Input: numRows = 1
 * Output: [[1]]
 *
 * Constraints:
 *
 * 1 <= numRows <= 30
 */
fun main() {
    println(
        generate(5)
    )
}

fun generate(numRows: Int): List<List<Int>> {
    val result = mutableListOf<MutableList<Int>>()
    for (i in 0 until numRows) {
        val list = mutableListOf<Int>()
        for (j in 0 .. i) {
            val li = i - 1
            val lj = j - 1
            val rj = j + 1
            list.add(
                if (li < 0 || lj < 0 || rj > i) {
                    1
                } else {
                    result[li][lj] + result[li][j]
                }
            )
        }
        result.add(list)
    }

    return result
}