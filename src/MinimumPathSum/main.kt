package MinimumPathSum

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * Example 1:
 *
 * Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
 * Output: 7
 * Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
 *
 * Example 2:
 *
 * Input: grid = [[1,2,3],[4,5,6]]
 * Output: 12
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 200
 * 0 <= grid[i][j] <= 100
 */

fun main() {
    println(
        minPathSum(
            arrayOf(
                intArrayOf(
                    1,3,1
                ),
                intArrayOf(
                    1,5,1
                ),
                intArrayOf(
                    4,2,1
                )
            )
        )
    )
}

fun minPathSum(grid: Array<IntArray>): Int {
    val map = Array(grid.size) { IntArray(grid[0].size) }
    map[0][0] = grid[0][0]
    for (i in 1 until grid[0].size) {
        map[0][i] = grid[0][i] + map[0][i - 1]
    }
    for(i in 1 until grid.size) {
        map[i][0] = grid[i][0] + map[i - 1][0]
    }
    for (i in 1 until grid.size) {
        for(j in 1 until grid[i].size) {
            map[i][j] = grid[i][j] + map[i - 1][j].coerceAtMost(map[i][j - 1])
        }
    }
    return map[grid.size - 1][grid[0].size - 1]
}