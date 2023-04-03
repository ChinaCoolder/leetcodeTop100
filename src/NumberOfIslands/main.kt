package NumberOfIslands

/**
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 *
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 *
 * Example 2:
 *
 * Input: grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * Output: 3
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] is '0' or '1'.
 */
fun main() {
    println(
        numIslands(
            arrayOf(
                charArrayOf(
                    '1','1','1'
                ),
                charArrayOf(
                    '0','1','0'
                ),
                charArrayOf(
                    '1','1','1'
                )
            )
//            arrayOf(
//                charArrayOf(
//                    '1','1','0','0','0'
//                ),
//                charArrayOf(
//                    '1','1','0','0','0'
//                ),
//                charArrayOf(
//                    '0','0','1','0','0'
//                ),
//                charArrayOf(
//                    '0','0','0','1','1'
//                )
//            )
        )
    )
}

fun numIslands(grid: Array<CharArray>): Int {
    var result = 0

    fun dfs(x: Int, y: Int) {
        if (
            x < 0 || y < 0 ||
            x > grid.lastIndex || y > grid[0].lastIndex ||
            grid[x][y] == '0'
        ) {
            return
        }
        grid[x][y] = '0'
        dfs(x - 1, y)
        dfs(x + 1, y)
        dfs(x, y - 1)
        dfs(x, y + 1)
    }

    for (i in grid.indices) {
        for (j in grid[i].indices) {
            if (grid[i][j] == '1') {
                result ++
                dfs(i, j)
            }
        }
    }

    return result
}

fun numIslands1(grid: Array<CharArray>): Int {
    var result = 0

    fun findIsland(
        map: Array<BooleanArray>
    ) {
        fun expandMap(x: Int, y: Int) {
            if (x - 1 >= 0 && grid[x - 1][y] == '1' && !map[x - 1][y]) {
                map[x - 1][y] = true
                expandMap(x - 1, y)
            }
            if (x + 1 < grid.size && grid[x + 1][y] == '1' && !map[x + 1][y]) {
                map[x + 1][y] = true
                expandMap(x + 1, y)
            }
            if (y - 1 >= 0 && grid[x][y - 1] == '1' && !map[x][y - 1]) {
                map[x][y - 1] = true
                expandMap(x, y - 1)
            }
            if (y + 1 < grid[x].size && grid[x][y + 1] == '1' && !map[x][y + 1]) {
                map[x][y + 1] = true
                expandMap(x, y + 1)
            }
        }

        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (map[i][j]) {
                    continue
                }
                if (grid[i][j] == '1') {
                    map[i][j] = true
                    result ++
                    expandMap(i, j)
                    findIsland(map)
                }
            }
        }
    }
    findIsland(
        Array(grid.size) {
            BooleanArray(grid[0].size){
                false
            }
        }
    )
    return result
}