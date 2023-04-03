package SearchA2DMatrix

/**
 * You are given an m x n integer matrix matrix with the following two properties:
 *
 * Each row is sorted in non-decreasing order.
 * The first integer of each row is greater than the last integer of the previous row.
 * Given an integer target, return true if target is in matrix or false otherwise.
 *
 * You must write a solution in O(log(m * n)) time complexity.
 *
 * Example 1:
 *
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * Output: true
 *
 * Example 2:
 *
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * Output: false
 *
 * Constraints:
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -104 <= matrix[i][j], target <= 104
 */
fun main() {
    println(
        searchMatrix(
            arrayOf(
                intArrayOf(
                    1,3,5,7
                ),
                intArrayOf(
                    10,11,16,20
                ),
                intArrayOf(
                    23,30,34,60
                )
            ),
            30
        )
    )
}

fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
    for (i in matrix.indices) {
        val start = matrix[i][0]
        val end = matrix[i][matrix[i].lastIndex]
        if (target == start || target == end) {
            return true
        } else if (target in (start + 1) until end) {
            for (j in 1 .. matrix[i].lastIndex) {
                if (matrix[i][j] == target) {
                    return true
                } else if(matrix[i][j] > target) {
                    return false
                }
            }
        }
    }
    return false
}