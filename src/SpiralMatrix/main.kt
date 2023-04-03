package SpiralMatrix

/**
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 *
 * Example 1:
 *
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 *
 * Example 2:
 *
 * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * Constraints:
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 */
fun main() {
    println(
        spiralOrder(
            arrayOf(
                intArrayOf(
                    1,2,3
                ),
                intArrayOf(
                    4,5,6
                ),
                intArrayOf(
                    7,8,9
                )
            )
        )
    )
}

fun spiralOrder(matrix: Array<IntArray>): List<Int> {
    if (matrix.size == 1) {
        return matrix[0].toList()
    }
    val boundary = intArrayOf(0, 0, 0, 0)
    val result = mutableListOf<Int>()
    var direction = 0
    while (true) {
        val left = boundary[3]
        val right = matrix[0].lastIndex - boundary[1]
        val top = boundary[0]
        val bottom = matrix.lastIndex - boundary[2]

        if (
            (direction % 2 == 0 && left > right) ||
            (direction % 2 == 1 && top > bottom)
        ) {
            break
        }

        val range = when(direction) {
            0 -> left .. right
            1 -> top .. bottom
            2 -> right downTo left
            else -> bottom downTo top
        }

        for (i in range) {
            result.add(
                when(direction) {
                    0 -> matrix[top][i]
                    1 -> matrix[i][right]
                    2 -> matrix[bottom][i]
                    else -> matrix[i][left]
                }
            )
        }

        boundary[direction] ++
        direction = if (direction + 1 <= 3) direction + 1 else 0
    }
    return result
}