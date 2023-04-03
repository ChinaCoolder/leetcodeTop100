package NQueens

/**
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
 *
 * Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
 *
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.
 *
 * Example 1:
 *
 * Input: n = 4
 * Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
 *
 * Example 2:
 *
 * Input: n = 1
 * Output: [["Q"]]
 *
 */
fun main() {
    println(
        solveNQueens(
            4
        )
    )
}

fun solveNQueens(n: Int): List<List<String>> {
    val result = mutableListOf<List<String>>()

    fun isValid(lineIndex: Int, rowIndex: Int, map: Array<IntArray>): Boolean {
        var i = lineIndex
        var j = rowIndex
        //top clean
        while (i >= 0) {
            if (map[i][j] == 1) {
                return false
            }
            i --
        }
        i = lineIndex
        j = rowIndex
        //top left clean
        while (i >= 0 && j >= 0) {
            if (map[i][j] == 1) {
                return false
            }
            i --
            j --
        }
        //top right clean
        i = lineIndex
        j = rowIndex
        while (i >= 0 && j < n) {
            if (map[i][j] == 1) {
                return false
            }
            i --
            j ++
        }

        return true
    }

    fun Array<IntArray>.convertQueen(): List<String> {
        val list = mutableListOf<String>()
        for (i in this.indices) {
            var temp = ""
            for(j in this[i].indices) {
                temp += if (this[i][j] == 1) "Q" else "."
            }
            list.add(temp)
        }
        return list
    }

    fun backTracking(step: Int, map: Array<IntArray>) {
        if (step == n + 1) {
            result.add(
                map.convertQueen()
            )
            return
        }
        for (j in 0 until n) {
            if (isValid(step - 1, j, map)) {
                map[step - 1][j] = 1
                backTracking(step + 1, map)
                map[step - 1][j] = 0
            }
        }
    }
    backTracking(1,
        Array(n){
            IntArray(n){
                0
            }
        }
    )
    return result
}

fun solveNQueens1(n: Int): List<List<String>> {
    if (n == 1) {
        return listOf(listOf("Q"))
    }
    val result = mutableListOf<MutableList<String>>()
    val resultSet = mutableSetOf<String>()
    val map = Array(n){
        IntArray(n) { index ->
            if (index == 0) 1 else 0
        }
    }

    fun Array<IntArray>.convertQueen(): MutableList<String> {
        var hash = ""
        val list = mutableListOf<String>().apply {
            for (i in map.indices) {
                var temp = ""
                for (j in map[i].indices) {
                    temp += if (map[i][j] == 1) {
                        "Q"
                    } else {
                        "."
                    }
                }
                this.add(temp)
                hash += temp
            }
        }
        return if (resultSet.contains(hash)){
            mutableListOf()
        } else {
            resultSet.add(hash)
            list
        }
    }


    fun isValid(map: Array<IntArray>): Boolean {
        val set = mutableSetOf<Int>()
        for (i in map.indices) {
            for (j in map[i].indices) {
                if (map[i][j] == 1) {
                    if (set.contains(j)) {
                        return false
                    } else {
                        set.add(j)
                    }
                    var iVal = i - 1
                    var jVal = j - 1
                    //left top clean
                    while (iVal >= 0 && jVal >= 0) {
                        if (map[iVal][jVal] == 1) {
                            return false
                        }
                        iVal --
                        jVal --
                    }
                    iVal = i - 1
                    jVal = j + 1
                    //right top clean
                    while (iVal >= 0 && jVal < n) {
                        if (map[iVal][jVal] == 1) {
                            return false
                        }
                        iVal --
                        jVal ++
                    }
                    //left bottom clean
                    iVal = i + 1
                    jVal = j - 1
                    while (iVal < n && jVal >= 0) {
                        if (map[iVal][jVal] == 1) {
                            return false
                        }
                        iVal ++
                        jVal --
                    }
                    //right bottom clean
                    iVal = i + 1
                    jVal = j + 1
                    while (iVal < n && jVal < n) {
                        if (map[iVal][jVal] == 1) {
                            return false
                        }
                        iVal ++
                        jVal ++
                    }
                }
            }
        }

        return true
    }

    fun backTracking(map: Array<IntArray>) {
        if (isValid(map)) {
            val list = map.convertQueen()
            if (list.isNotEmpty()) {
                result.add(list)
            }
            return
        }
        for (i in map.indices) {
            for (j in map[i].indices) {
                if (map[i][j] == 1 && j != n - 1) {
                    map[i][j] = 0
                    map[i][j + 1] = 1
                    backTracking(map)
                    map[i][j] = 1
                    map[i][j + 1] = 0
                }
            }
        }
    }
    backTracking(map)
    return result
}