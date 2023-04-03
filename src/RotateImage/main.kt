package RotateImage

import ContainerWithMostWater.maxArea

/**
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 *
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 *
 * Example 1:
 *
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[7,4,1],[8,5,2],[9,6,3]]
 *
 * Example 2:
 *
 * Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 *
 * Constraints:
 *
 * n == matrix.length == matrix[i].length
 * 1 <= n <= 20
 * -1000 <= matrix[i][j] <= 1000
 */

fun main() {
    var matrix = arrayOf(
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
    rotate(matrix)

    matrix = arrayOf(
        intArrayOf(
            5,1,9,11
        ),
        intArrayOf(
            2,4,8,10
        ),
        intArrayOf(
            13,3,6,7
        ),
        intArrayOf(
            15,14,12,16
        )
    )
    rotate(matrix)

    println(matrix)
}

fun rotate(matrix: Array<IntArray>) {
    if (matrix.size == 1)
        return

    fun swap(s1: IntArray, s2: IntArray, p1: Int, p2: Int) {
        val temp = s1[p1]
        s1[p1] = s2[p2]
        s2[p2] = temp
    }

    val matrixSize = matrix.size
    val matrixMaxIndex = matrixSize - 1

    for (i in 0 until matrixSize / 2) {
        for (j in i until matrixMaxIndex - i) {
            swap(matrix[i], matrix[matrixMaxIndex - j], j, i)
            swap(matrix[matrixMaxIndex - j], matrix[matrixMaxIndex - i], i, matrixMaxIndex - j)
            swap(matrix[matrixMaxIndex - i], matrix[j], matrixMaxIndex - j, matrixMaxIndex - i)
        }
    }
}