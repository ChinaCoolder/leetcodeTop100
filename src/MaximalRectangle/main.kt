package MaximalRectangle

/**
 * Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 *
 * Example 1:
 *
 * Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * Output: 6
 * Explanation: The maximal rectangle is shown in the above picture.
 *
 * Example 2:
 *
 * Input: matrix = [["0"]]
 * Output: 0
 *
 * Example 3:
 *
 * Input: matrix = [["1"]]
 * Output: 1
 *
 * Constraints:
 *
 * rows == matrix.length
 * cols == matrix[i].length
 * 1 <= row, cols <= 200
 * matrix[i][j] is '0' or '1'.
 */

fun main() {
    println(
        maximalRectangle(
            arrayOf(
                charArrayOf(
                    '1','0','1','0','0'
                ),
                charArrayOf(
                    '1','0','1','1','1'
                ),
                charArrayOf(
                    '1','1','1','1','1'
                ),
                charArrayOf(
                    '1','0','0','1','0'
                )
            )
        )
    )
}

fun maximalRectangle(matrix: Array<CharArray>): Int {
    if (matrix.size == 1 && matrix[0].size == 1) {
        return if (matrix[0][0] == '1') 1 else 0
    }

    fun greedyExpand(iVal: Int, jVal: Int): Int {
        var lti = iVal
        var ltj = jVal
        var rbi = iVal
        var rbj = jVal
        while (true) {
            //move to left top
            if (lti - 1 >= 0 && ltj - 1 >= 0 && matrix[lti - 1][ltj - 1] == '1') {
                var topExpandable = true
                var leftExpandable = true
                for (i in lti .. rbi) {
                    if (matrix[i][ltj - 1] != '1') {
                        leftExpandable = false
                        break
                    }
                }
                if (leftExpandable) {
                    for (i in ltj .. rbj) {
                        if (matrix[lti - 1][i] != '1') {
                            topExpandable = false
                            break
                        }
                    }
                    if (topExpandable) {
                        lti --
                        ltj --
                        continue
                    }
                }
            }
            //move to right bottom
            if (rbi + 1 < matrix.size && rbj + 1 < matrix[0].size && matrix[rbi + 1][rbj + 1] == '1') {
                var bottomExpandable = true
                var rightExpandable = true
                for (i in lti .. rbi) {
                    if (matrix[i][rbj + 1] != '1') {
                        rightExpandable = false
                        break
                    }
                }
                if (rightExpandable) {
                    for (i in ltj .. rbj) {
                        if (matrix[rbi + 1][i] != '1') {
                            bottomExpandable = false
                            break
                        }
                    }
                    if (bottomExpandable) {
                        rbi ++
                        rbj ++
                        continue
                    }
                }
            }

            //move to top
            if (lti - 1 >= 0 && matrix[lti - 1][ltj] == '1') {
                var topExpandable = true
                for (i in ltj .. rbj) {
                    if (matrix[lti - 1][i] != '1') {
                        topExpandable = false
                        break
                    }
                }
                if (topExpandable) {
                    lti --
                    continue
                }
            }

            //move to left
            if (ltj - 1 >= 0 && matrix[lti][ltj - 1] == '1') {
                var leftExpandable = true
                for (i in lti .. rbi) {
                    if (matrix[i][ltj - 1] != '1') {
                        leftExpandable = false
                        break
                    }
                }
                if (leftExpandable) {
                    ltj --
                    continue
                }
            }

            //move to bottom
            if (rbi + 1 < matrix.size && matrix[rbi + 1][rbj] == '1') {
                var bottomExpandable = true
                for (i in ltj .. rbj) {
                    if (matrix[rbi + 1][i] != '1') {
                        bottomExpandable = false
                        break
                    }
                }
                if (bottomExpandable) {
                    rbi ++
                    continue
                }
            }

            //move to right
            if (rbj + 1 < matrix[0].size && matrix[rbi][rbj + 1] == '1') {
                var rightExpandable = true
                for (i in lti .. rbi) {
                    if (matrix[i][rbj + 1] != '1') {
                        rightExpandable = false
                        break
                    }
                }
                if (rightExpandable) {
                    rbj ++
                    continue
                }
            }

            break
        }

        return (rbi - lti + 1) * (rbj - ltj + 1)
    }

    var result = 0
    val maxSize = (matrix.size * matrix[0].size)
    for (i in matrix.indices) {
        for (j in matrix[i].indices) {
            if (matrix[i][j] == '1') {
                result = result.coerceAtLeast(
                    greedyExpand(
                        i, j
                    )
                )
                if (result == maxSize) {
                    return result
                }
            }
        }
    }

    return result
}

fun maximalRectangle1(matrix: Array<CharArray>): Int {
    if (matrix.size == 1 && matrix[0].size == 1) {
        return if (matrix[0][0] == '1') 1 else 0
    }

    fun backtracking(leftTopI: Int, leftTopJ: Int, rightBottomI: Int, rightBottomJ: Int): Int {
        for (i in leftTopI .. rightBottomI) {
            for(j in leftTopJ .. rightBottomJ) {
                if (matrix[i][j] != '1') {
                    return  0
                }
            }
        }

        var temp = (rightBottomI - leftTopI + 1) * (rightBottomJ - leftTopJ + 1)
        //move to left top
        if (leftTopI - 1 >= 0 && leftTopJ - 1 >= 0) {
            val temp1 = temp
            temp = temp.coerceAtLeast(
                backtracking(
                    leftTopI - 1,
                    leftTopJ - 1,
                    rightBottomI,
                    rightBottomJ
                )
            )
            if (temp > temp1) {
                return temp1
            }
        }
        //move to right bottom
        if (rightBottomI + 1 < matrix.size && rightBottomJ + 1 < matrix[0].size) {
            val temp1 = temp
            temp = temp.coerceAtLeast(
                backtracking(
                    leftTopI,
                    leftTopJ,
                    rightBottomI + 1,
                    rightBottomJ + 1
                )
            )
            if (temp > temp1) {
                return temp1
            }
        }

        // move to top
        if (leftTopI - 1 >= 0) {
            temp = temp.coerceAtLeast(
                backtracking(
                    leftTopI - 1,
                    leftTopJ,
                    rightBottomI,
                    rightBottomJ
                )
            )
        }

        //move to left
        if (leftTopJ - 1 >= 0) {
            temp = temp.coerceAtLeast(
                backtracking(
                    leftTopI,
                    leftTopJ - 1,
                    rightBottomI,
                    rightBottomJ
                )
            )
        }

        //move to bottom
        if (rightBottomI + 1 < matrix.size) {
            temp = temp.coerceAtLeast(
                backtracking(
                    leftTopI,
                    leftTopJ,
                    rightBottomI + 1,
                    rightBottomJ
                )
            )
        }

        //move to right
        if (rightBottomJ + 1 < matrix[0].size) {
            temp = temp.coerceAtLeast(
                backtracking(
                    leftTopI,
                    leftTopJ,
                    rightBottomI,
                    rightBottomJ + 1
                )
            )
        }

        return temp
    }

    var result = 0
    val maxSize = (matrix.size * matrix[0].size) / 2
    for (i in matrix.indices) {
        for (j in matrix[i].indices) {
            if (matrix[i][j] == '1') {
                result = result.coerceAtLeast(
                    backtracking(
                        i, j, i, j
                    )
                )
                if (result >= maxSize) {
                    return result
                }
            }
        }
    }

    return result
}