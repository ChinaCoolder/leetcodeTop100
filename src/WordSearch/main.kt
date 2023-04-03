package WordSearch

/**
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 * Example 1:
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * Output: true
 *
 * Example 2:
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * Output: true
 *
 * Example 3:
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * Output: false
 *
 * Constraints:
 *
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board and word consists of only lowercase and uppercase English letters.
 */

fun main() {
    println(
        exist(
            arrayOf(
                charArrayOf(
                    'A','B','C','E'
                ),
                charArrayOf(
                    'S','F','C','S'
                ),
                charArrayOf(
                    'A','D','E','E'
                )
            ),
            "SEE"
        )
    )
}

fun exist(board: Array<CharArray>, word: String): Boolean {
    if (word.length == 1 && board[0][0] == word[0]) {
        return true
    }

    fun track(i: Int, j: Int, size: Int, visited: Array<BooleanArray>): Boolean {
        if (size == word.length) {
            return true
        }

        if (i - 1 >= 0 && board[i - 1][j] == word[size] && !visited[i - 1][j]) {
            visited[i - 1][j] = true
            if (track(i - 1, j, size + 1, visited)) {
                return true
            }
            visited[i - 1][j] = false
        }

        if (j - 1 >= 0 && board[i][j - 1] == word[size] && !visited[i][j - 1]) {
            visited[i][j - 1] = true
            if (track(i, j - 1, size + 1, visited)) {
                return true
            }
            visited[i][j - 1] = false
        }

        if (i + 1 < board.size && board[i + 1][j] == word[size] && !visited[i + 1][j]) {
            visited[i + 1][j] = true
            if (track(i + 1, j, size + 1, visited)) {
                return true
            }
            visited[i + 1][j] = false
        }

        if (j + 1 < board[i].size && board[i][j + 1] == word[size] && !visited[i][j + 1]) {
            visited[i][j + 1] = true
            if (track(i, j + 1, size + 1, visited)) {
                return true
            }
            visited[i][j + 1] = false
        }

        return false
    }

    for (i in board.indices) {
        for (j in board[i].indices) {
            if (board[i][j] == word[0]) {
                if (track(i, j, 1, Array(board.size) {BooleanArray(board[i].size)}.apply {
                    this[i][j] = true
                    })) {
                    return true
                }
            }
        }
    }
    return false
}