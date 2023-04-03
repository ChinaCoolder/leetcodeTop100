package SearchA2DMatrixII

/**
 * Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 *
 * Example 1:
 *
 * Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * Output: true
 *
 * Example 2:
 *
 * Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
 * Output: false
 */
fun main() {
    println(
        searchMatrix(
            arrayOf(
                intArrayOf(
                    1,2,3,4,5
                ),
                intArrayOf(
                    6,7,8,9,10
                ),
                intArrayOf(
                    11,12,13,14,15
                ),
                intArrayOf(
                    16,17,18,19,20
                ),
                intArrayOf(
                    21,22,23,24,25
                )
            ),
            8
        )
    )
}

fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
    var row = 0
    var col = matrix[0].lastIndex
    while (row <= matrix.lastIndex && col >= 0) {
        if (matrix[row][col] == target) {
            return true
        } else if(matrix[row][col] > target) {
            col --
        } else {
            row ++
        }
    }
    return false
}

fun searchMatrix2(matrix: Array<IntArray>, target: Int): Boolean {
    if (target > matrix.last().last()) {
        return false
    }
    var i = 0
    while (i < matrix.size && matrix[i][0] <= target) {
        if (matrix[i][0] == target) {
            return true
        }
        var j = 0
        while (j < matrix[0].size && matrix[i][j] <= target) {
            if (matrix[i][j] == target) {
                return true
            }
            j ++
        }
        i ++
    }
    return false
}

fun searchMatrix1(matrix: Array<IntArray>, target: Int): Boolean {
    var result = false

    fun bfs(x: Int, y: Int, map: Array<BooleanArray>) {
        if (result) {
            return
        }
        if (matrix[x][y] == target) {
            result = true
            return
        }
        if (x + 1 <= matrix.lastIndex && !map[x + 1][y] && matrix[x + 1][y] <= target) {
            map[x + 1][y] = true
            bfs(x + 1, y, map)
            map[x + 1][y] = false
        }
        if (y + 1 <= matrix[0].lastIndex && !map[x][y + 1] && matrix[x][y + 1] <= target) {
            map[x][y + 1] = true
            bfs(x, y + 1, map)
            map[x][y + 1] = false
        }
    }
    bfs(0,0, Array(matrix.size){ BooleanArray(matrix[0].size){false} })
    return result
}