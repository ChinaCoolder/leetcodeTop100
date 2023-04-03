package SetMatrixZeroes

/**
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
 *
 * You must do it in place.
 *
 * Example 1:
 *
 * Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * Output: [[1,0,1],[0,0,0],[1,0,1]]
 *
 * Example 2:
 *
 * Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 *
 * Constraints:
 *
 * m == matrix.length
 * n == matrix[0].length
 * 1 <= m, n <= 200
 * -231 <= matrix[i][j] <= 231 - 1
 */
fun main() {
    val matrix = arrayOf(
        intArrayOf(1,1,1),
        intArrayOf(1,0,1),
        intArrayOf(1,1,1)
    )
    setZeroes(matrix)
    println(
        matrix.contentDeepToString()
    )
}

fun setZeroes(matrix: Array<IntArray>) {
    var firstRowHaveZero = false
    var firstColHaveZero = false
    for (i in matrix[0].indices) {
        if (matrix[0][i] == 0) {
            firstRowHaveZero = true
            break
        }
    }
    for (i in matrix.indices) {
        if (matrix[i][0] == 0) {
            firstColHaveZero = true
            break
        }
    }
    for (i in 1 .. matrix.lastIndex) {
        for (j in 1 .. matrix[i].lastIndex) {
            if (matrix[i][j] == 0) {
                matrix[0][j] = 0
                matrix[i][0] = 0
            }
        }
    }
    for (i in 1 .. matrix.lastIndex) {
        for (j in 1 .. matrix[0].lastIndex) {
            if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                matrix[i][j] = 0
            }
        }
    }
    if (firstRowHaveZero) {
        for (i in matrix[0].indices) {
            matrix[0][i] = 0
        }
    }
    if (firstColHaveZero) {
        for (i in matrix.indices) {
            matrix[i][0] = 0
        }
    }
}