package RottingOranges

import java.util.*

/**
 * You are given an m x n grid where each cell can have one of three values:
 *
 * 0 representing an empty cell,
 * 1 representing a fresh orange, or
 * 2 representing a rotten orange.
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
 *
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
 * Output: 4
 * Example 2:
 *
 * Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
 * Output: -1
 * Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
 * Example 3:
 *
 * Input: grid = [[0,2]]
 * Output: 0
 * Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 10
 * grid[i][j] is 0, 1, or 2.
 */
fun main() {
    println(
        orangesRotting(
            arrayOf(
                intArrayOf(2,1,1),
                intArrayOf(1,1,0),
                intArrayOf(0,1,1)
            )
        )
    )
}

fun orangesRotting(grid: Array<IntArray>): Int {
    val queue = LinkedList<Pair<Int, Int>>()
    var freshCount = 0
    var minute = 0

    // 初始化，将所有腐烂的橘子加入队列
    for (i in grid.indices) {
        for (j in grid[i].indices) {
            when (grid[i][j]) {
                2 -> queue.offer(Pair(i, j))
                1 -> freshCount++
            }
        }
    }

    // BFS搜索
    while (queue.isNotEmpty() && freshCount > 0) {
        val size = queue.size

        for (i in 0 until size) {
            val (x, y) = queue.poll()
            val dx = intArrayOf(-1, 0, 1, 0)
            val dy = intArrayOf(0, 1, 0, -1)

            for (j in 0 until 4) {
                val newX = x + dx[j]
                val newY = y + dy[j]

                if (newX in grid.indices && newY in grid[0].indices && grid[newX][newY] == 1) {
                    grid[newX][newY] = 2
                    queue.offer(Pair(newX, newY))
                    freshCount--
                }
            }
        }

        minute++
    }

    return if (freshCount == 0) minute else -1
}